package com.security.demo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.Mongo;

public class MapReduceBooks {
	public static void main(String[] args) {


        Mongo mongo;

        try {
            mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("library");

            DBCollection books = db.getCollection("books");

            BasicDBObject book = new BasicDBObject();
            book.put("name", "Understanding JAVA");
            book.put("pages", 100);
            books.insert(book);

            book = new BasicDBObject();
            book.put("name", "Understanding JSON");
            book.put("pages", 200);
            books.insert(book);

            book = new BasicDBObject();
            book.put("name", "Understanding XML");
            book.put("pages", 300);
            books.insert(book);

            book = new BasicDBObject();
            book.put("name", "Understanding Web Services");
            book.put("pages", 400);
            books.insert(book);

            book = new BasicDBObject();
            book.put("name", "Understanding Axis2");
            book.put("pages", 150);
            books.insert(book);

            //200页以上的是大书，小于200页的是小书
            String map = "function(){" +
                    "var type;" +
                    "if (this.pages>200) type='big'; else type='mini';" +
                    "emit(type,{name:this.name})}";

            //大书小书汇总
            String reduce ="function(key, values) { " +
                    "var sum = 0; " +
                    "values.forEach(function() { " +
                    "sum += 1; }); " +
                    "return {bookSum: sum};} ";

            MapReduceCommand cmd = new MapReduceCommand(books, map, reduce,
                    null, MapReduceCommand.OutputType.INLINE, null);

            MapReduceOutput out = books.mapReduce(cmd);

            for (DBObject o : out.results()) {
                System.out.println(o.toString());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();


      }
   }

}
