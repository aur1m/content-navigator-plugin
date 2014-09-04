/*
* CloseAccountService.java
* Aug 20, 2013
*
* Artyush
* (c) Copyright IBA, 2013
*/
package com.ibm.ecm.extension.CloseAccountPlugin;

import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.filenet.api.constants.RefreshMode;
import com.filenet.api.core.Document;
import com.filenet.api.core.Domain;
import com.filenet.api.core.Factory;
import com.filenet.api.core.ObjectStore;
import com.filenet.api.util.Id;
import com.ibm.ecm.extension.PluginService;
import com.ibm.ecm.extension.PluginServiceCallbacks;

/**
 * Class {@link }.
 * 
 * @author Artyush
 */
public class CloseAccountService extends PluginService
{

  /** 
   * @see com.ibm.ecm.extension.PluginService#execute(com.ibm.ecm.extension.PluginServiceCallbacks, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
   */
  @Override
  public void execute(PluginServiceCallbacks callbacks, HttpServletRequest request, HttpServletResponse response) throws Exception
  {

    String serviceType = request.getParameter("ServiceType");
    if (serviceType != null && serviceType.equals("GetConfig"))
    {
      String configuration = callbacks.loadConfiguration();
      Writer w = response.getWriter();
      w.write(configuration);
      w.flush();
    }
    else
    {
      try
      {
        String serverType = request.getParameter("serverType");
        System.out.println("Att=" + request.getAttributeNames().toString());
        System.out.println("Param=" + request.getParameterNames().toString());
        System.out.println("serverType=" + request.getParameter("serverType"));
        String server = request.getParameter("server");
        System.out.println("server=" + request.getParameter("server"));
        String dateValueStr = request.getParameter("date");
        System.out.println("date=" + request.getParameter("date"));
        DateFormat formatter = new SimpleDateFormat("yyyy-M-d");
        Date date = formatter.parse(dateValueStr);
        int ndocs = Integer.parseInt(request.getParameter("ndocs"));
        List<String> docIDs = new ArrayList<String>();
        for (int i = 0; i < ndocs; i++)
        {
          String docIdString = request.getParameter("docID" + i);
          if (docIdString != null)
          {
            docIDs.add(docIdString);
          }
        }
        int numUpdated = 0;
        if (!docIDs.isEmpty())
        {
          if (serverType.equals("p8"))
          {
            numUpdated = updateDocumentsP8(callbacks, server, docIDs, date);
          }
        }
        PrintWriter respWriter = response.getWriter();
        respWriter.print("{\"results\":{\"numUpdated\":\"" + numUpdated + "\"}}");
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
  }

  /**
   * @param callbacks
   * @param server
   * @param docIDs
   * @param newDateValue
   * @return
   */
  public int updateDocumentsP8(PluginServiceCallbacks callbacks, String server, List<String> docIDs, Date newDateValue)
  {
    int numUpdated = 0;
    Domain domain = callbacks.getP8Domain(server);
    Iterator<String> listIter = docIDs.iterator();
    while (listIter.hasNext())
    {
      String[] splitObjectId = listIter.next().split(",");
      if (splitObjectId.length >= 3)
      {
        String docID = splitObjectId[2];
        String osStr = splitObjectId[1];
        ObjectStore os = Factory.ObjectStore.fetchInstance(domain, new Id(osStr), null);
        Document document = Factory.Document.fetchInstance(os, docID, null);
        document.getProperties().putValue("Att_CreaDate", newDateValue);
        document.save(RefreshMode.REFRESH);
        numUpdated++;
      }
    }
    return numUpdated;
  }

  /** 
   * @see com.ibm.ecm.extension.PluginService#getId()
   */
  @Override
  public String getId()
  {
    return "CloseAccountService";
  }

}
