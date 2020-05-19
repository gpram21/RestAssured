package RestAssured;

import io.restassured.path.json.JsonPath;

public class complexJson {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(Files.payload.CoursePrice());
        //print number of course
        int count =  js.getInt("courses.size()");
        System.out.println(count);

        int totalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);

        String firstCourse = js.get("courses[0].title");
       // System.out.println(firstCourse);

        for(int i=0; i<count; i++){
            String titles = js.get("courses[" + i +"].title");
            if(titles.equalsIgnoreCase("RPA"))
                System.out.println(titles);
        }
        int sum = 0;
        for(int j=0;j<count;j++){
            int courseprice = js.get("courses[" + j +"].price");
            int copies = js.get("courses[" + j +"].copies");

            sum = sum + (courseprice * copies);
        }
        System.out.println(sum);

    }
}
