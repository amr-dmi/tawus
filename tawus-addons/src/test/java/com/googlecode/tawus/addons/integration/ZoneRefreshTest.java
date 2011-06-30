// 
// Copyright 2011 Taha Hafeez Siddiqi (tawushafeez@gmail.com)
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//   http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
package com.googlecode.tawus.addons.integration;

import org.apache.tapestry5.test.SeleniumTestCase;
import org.testng.annotations.Test;

public class ZoneRefreshTest extends SeleniumTestCase
{
   @Test
   public void test_if_two_zones_get_updated() throws Exception
   {
      openBaseURL();
      clickAndWait("link=Zone Refresh Demo");
      checkZoneValues(3);
   }

   private void checkZoneValues(int times) throws Exception
   {
      Thread.sleep(1000);
      for(int i = 0; i < times; ++i)
      {
         assertText("zone", String.valueOf(i));
         Thread.sleep(3000);
      }
   }

}
