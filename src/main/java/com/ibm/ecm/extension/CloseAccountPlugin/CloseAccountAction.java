/*
* CloseAccountAction.java
* Aug 20, 2013
*
* Artyush
* (c) Copyright IBA, 2013
*/
package com.ibm.ecm.extension.CloseAccountPlugin;

import java.util.Locale;

import com.ibm.ecm.extension.PluginAction;

/**
 * Class {@link }.
 * 
 * @author Artyush
 */
public class CloseAccountAction extends PluginAction
{

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getActionModelClass()
   */
  @Override
  public String getActionModelClass()
  {
    return "samplePluginDojo.CloseAccountActionModel";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getActionFunction()
   */
  @Override
  public String getActionFunction()
  {
    return "closeAccountFunction";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getIcon()
   */
  @Override
  public String getIcon()
  {
    return "";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getId()
   */
  @Override
  public String getId()
  {
    return "2.0";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getName(java.util.Locale)
   */
  @Override
  public String getName(Locale anLocale)
  {
    return "Close Account";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getPrivilege()
   */
  @Override
  public String getPrivilege()
  {
    return "privEditProperties";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#getServerTypes()
   */
  @Override
  public String getServerTypes()
  {
    return "p8";
  }

  /** 
   * @see com.ibm.ecm.extension.PluginAction#isMultiDoc()
   */
  @Override
  public boolean isMultiDoc()
  {
    return true;
  }

}
