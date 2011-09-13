package com.googlecode.tawus;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class EntityEditFormDemoTest extends BaseTestCase {
   
   @Test
   public void test_entity_save_with_ajax() throws InterruptedException {
      openBaseURL();
      clickAndWait("link=Entity Edit Form Ajax");
      
      fillForm();

      click("//form[1]//input[@type='submit'][1]");
      assertTextUsingJS("message", "Tawus created");
   }

   private void fillForm()
   {
      Map<String, String> params = new HashMap<String, String>();
      params.put("name", "Tawus");
      params.put("address", "Srinagar");
      params.put("age", "32");
      params.put("department", "1");//Select option value for Computers
      params.put("id_0", "10");
      params.put("gender", "1");//Male
      params.put("otherDepartments-values", "[1]");
      
      //Check if all the fields are present
      for (String field : params.keySet()) {
         assertTrue(isElementPresent("name=" + field), "Field " + field + " is present");
      }
      
      type("name=name", params.get("name"));
      type("name=address", params.get("address"));
      type("name=age", params.get("age"));
      type("name=id_0", params.get("id_0"));
      select("name=department", "value=1");
      select("name=gender", "value=Male");
   }

   @Test
   public void test_entity_cancel_with_ajax() throws InterruptedException {
      openBaseURL();
      clickAndWait("link=Entity Edit Form Ajax");
      click("id=cancel");
      assertTextUsingJS("message", "Message cleared");
   }
   
   @Test
   public void test_entity_save() throws InterruptedException {
      openBaseURL();
      clickAndWait("link=Entity Edit Form Demo");
      fillForm();
      clickAndWait("//form[1]//input[@type='submit'][1]");
      assertText("id=message", "Tawus/Srinagar/Computers/32/[]/Male");
   }

   @Test
   public void test_entity_cancel() throws InterruptedException {
      openBaseURL();
      clickAndWait("link=Entity Edit Form Demo");
      clickAndWait("id=cancel");
      assertText("id=message", "Message cleared");
   }
}
