public class Array {
    public static void main(String[] args) {
        int employee[] = new int[5];
        employee[0] = 15;
       // System.out.println(employee[0]);

        int emp[] [] = {{1,2},{3,4}};

      //  System.out.println(emp[1][1]);
        for(int i=0;i<emp.length;i++){
            for(int j=0;j<emp.length;j++){
                System.out.println(emp[i][j]);
            }
        }
    }
}
