package com.googlecode.tawus.app0.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;

import com.googlecode.tawus.SearchCriteria;
import com.googlecode.tawus.app0.models.User;

public class EntityGridDemo
{

   @Persist
   @Property
   private SearchCriteria<User> criteria;

   @SuppressWarnings("unused")
   @Property
   private User user;

   void onActivate(String param)
   {
      if(criteria == null)
      {
         criteria = new SearchCriteria<User>(User.class);
      }

      if("enabled".equals(param))
      {
         criteria.setEnabled(true);
      }
      else if("disabled".equals(param))
      {
         criteria.setEnabled(false);
      }
   }

   public String getSortColumn()
   {
      if(criteria.getOrder().size() == 0)
      {
         return "none";
      }
      String sortColumn = criteria.getOrder().keySet().iterator().next();
      return sortColumn + "/" + criteria.getOrder().get(sortColumn);
   }
}
