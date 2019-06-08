package enum_tutorial;

public class EnumPractice {
    public void printDesigValues(){
        for (int i=0; i<DesignationEnum.values().length; i++){
            System.out.println(DesignationEnum.values()[i]);
        }
    }

    public static void main(String s[]){
    EnumPractice enumPractice = new EnumPractice();
    enumPractice.printDesigValues();
    System.out.print(DesignationEnum.CEO.returnDetails());
    System.out.print(DesignationEnum.CTO.getGrades());
    }
}
 enum DesignationEnum implements DetailsInterface{
    CEO("chief executive officer"){
        public String getGrades(){
            return "1";
        }
    }, CFO("Chief Finance Officer"){
         public String getGrades(){
             return "2";
         }
     }, CTO("Chief Technical Officer"){
         public String getGrades(){
             return "3";
         }
     };
    private String details;
     public abstract String getGrades();
    DesignationEnum(String desig_details){
        this.details = desig_details;
    }

     @Override
     public String returnDetails() {
         return this.details;
     }

 }