package com.liulangf.pattern.eda.util;

/**
 * Interface shared by all <em>listeners</em>.
 * 
 * @author <a href="mailto:info@geosoft.no">GeoSoft</a>
 */   
public interface EventListener
{
  /**
   * Called in response to a notify() call on the EventManager if the
   * present listener is registered to listen for the given event.
   * 
   * @param eventName  Name of the event.
   * @param source     The source the event (as defined by caller).
   * @param data       Additinal data (as defined by caller).
   */
  public void update (String eventName, Object source, Object data);
}


