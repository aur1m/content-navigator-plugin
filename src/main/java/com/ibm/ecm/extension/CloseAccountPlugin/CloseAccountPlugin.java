/*
* CloseAccountPlugin.java
* Aug 20, 2013
*
* Artyush
* (c) Copyright IBA, 2013
*/
package com.ibm.ecm.extension.CloseAccountPlugin;

import java.util.Locale;

import com.ibm.ecm.extension.Plugin;
import com.ibm.ecm.extension.PluginAction;
import com.ibm.ecm.extension.PluginService;

/**
 * Class {@link }.
 * 
 * @author Artyush
 */
public class CloseAccountPlugin extends Plugin
{

  /** 
   * @see com.ibm.ecm.extension.Plugin#getConfigurationDijitClass()
   */
  @Override
  public String getConfigurationDijitClass()
  {
    return "samplePluginDojo.CloseAccountConfigPane";
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getDojoModule()
   */
  @Override
  public String getDojoModule()
  {
    return "samplePluginDojo";
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getActions()
   */
  @Override
  public PluginAction[] getActions()
  {
    return new PluginAction[] { new CloseAccountAction() };
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getScript()
   */
  @Override
  public String getScript()
  {
    return "CloseAccountPlugin.js";
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getServices()
   */
  @Override
  public PluginService[] getServices()
  {
    return new PluginService[] { new CloseAccountService() };
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getId()
   */
  @Override
  public String getId()
  {
    return "CloseAccountPlugin";
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getName(java.util.Locale)
   */
  @Override
  public String getName(Locale anArg0)
  {
    return "CloseAccountPlugin";
  }

  /** 
   * @see com.ibm.ecm.extension.Plugin#getVersion()
   */
  @Override
  public String getVersion()
  {
    return "2.0.0";
  }

}
