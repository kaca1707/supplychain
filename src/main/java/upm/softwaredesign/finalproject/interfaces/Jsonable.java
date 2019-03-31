package upm.softwaredesign.finalproject.interfaces;

interface Jsonable
{

  /**
   * Covert the object class into a Json format string
   */
  public String toJson();

  /**
   * Populate class with data from Json format string
   * @param String in json format
   */
  public void fromJson();

}
