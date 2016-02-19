import javax.swing.JOptionPane;
public class sum{
  public static void main(String[] args){
  }
  public static void run(String resistanceinput){
     
     
//gets input makes sure it’s valid..
  
     final long resistanceinputrandom =  Long.parseLong(resistanceinput);  
     
     
     
     

     
      
 //------------------------------------------------------------------------------------------------------------------------   
   //rounding stuff
   final long length = resistanceinput.length(); 
    final long random  = length - 2;
    String randomtwo = roundingmethod(random); 
    final long finalnum =Integer.parseInt(randomtwo);
    final long newinput = Math.round(resistanceinputrandom/finalnum)*finalnum;
// -----------------------------------------------------------------------------------------------------------------------   
    final long newinputint = newinput;
    String newinputswag = Long.toString(newinputint);
  
  //--------------------------------------------------------------------------------------------------------------------
    
    
    JOptionPane.showMessageDialog(null,"Actual Resistance: " + (long)newinput + gui.letter + "\nBands:\n" + "1. "+ FirstBand(newinputswag)+ "\n2. " +  SecondBand(newinputswag) + "\n3. " + multipler(newinput, newinputswag) + "\n4. " + tolerancemethod(resistanceinputrandom,newinput),"Bands", JOptionPane.INFORMATION_MESSAGE);  
  
  }
    
  
  public static String roundingmethod (long random){
    String randomtwo = "10";
    for(int count = 1; count < random; count++) {
      randomtwo= randomtwo + "0" ;
    }
    return randomtwo;
  }//1st method
  
  
  public static String tolerancemethod (final long resistanceinputrandom, final long newinput){
    double percenttwo = newinput*0.02;
     double percenttwoplus = newinput + percenttwo; 
     double percenttwominus = newinput - percenttwo;
     String tolerance = "no band";
 //-------------------------------------------    
     double percentfive = newinput*0.05;
     double percentfiveplus = newinput + percentfive; 
     double percentfiveminus = newinput - percentfive;
  //-------------------------------------------  
     double percentten = newinput*0.1;
     double percenttenplus = newinput + percentten; 
     double percenttenminus = newinput - percentten;
  //-------------------------------------------  
     if(resistanceinputrandom < percenttwoplus && resistanceinputrandom > percenttwominus){
       tolerance = "Red";
       return tolerance;
     }
     
     else if(resistanceinputrandom < percentfiveplus && resistanceinputrandom > percentfiveminus){
       tolerance = "Gold";
       return tolerance;
     }
      else if(resistanceinputrandom < percenttenplus && resistanceinputrandom > percenttenminus){
       tolerance = "Silver";
       return tolerance;
     } 
     else{
       return tolerance;}
          
}

public static String multipler(final long newinput, String newinputswag){

  char one = newinputswag.charAt(0);//first digit
      char two = newinputswag.charAt(1);//second
int oneholder= Character.digit(one, 10);
int twoholder = Character.digit(two, 10);
String oneholderword =  Integer.toString(oneholder);
String twoholderword =  Integer.toString(twoholder);
String totaldigits = oneholderword + twoholderword;
int divider = Integer.parseInt(totaldigits);
final long divder2=divider;
final long multiplier = (newinput/divder2); 
String multipliercolor;
switch((int)multiplier){
  case 1:multipliercolor="Black";
          break;
  case 10:multipliercolor="Brown";
          break;
  case 100:multipliercolor="Red";
            break;
  case 1000:multipliercolor="Orange";
            break;
  case 10000:multipliercolor="Yellow";
            break;
  case 100000:multipliercolor="Green";
            break;
  case 1000000:multipliercolor="Blue";  
            break;
  case 10000000:multipliercolor="Violet";
            break;
  case 100000000:multipliercolor="Gray";
            break;
  default:multipliercolor="White";
  break;
  
}
return multipliercolor;
}

public static String SecondBand(String newinputswag){
  String SecondBandColor[] = new String [10];
      char two = newinputswag.charAt(1);//second
int twoholder = Character.digit(two, 10);

  SecondBandColor[0] = "Black";
  SecondBandColor[1] = "Brown";
  SecondBandColor[2] = "Red";
  SecondBandColor[3] = "Orange";
  SecondBandColor[4] = "Yellow";
  SecondBandColor[5] = "Green";
  SecondBandColor[6] = "Blue";
  SecondBandColor[7] = "Violet";
  SecondBandColor[8] = "Gray";
  SecondBandColor[9] = "White";

  return SecondBandColor[twoholder];
}

public static String FirstBand(String newinputswag){
  String SecondBandColor[] = new String [10];
      char one = newinputswag.charAt(0);
int oneholder = Character.digit(one, 10);

  SecondBandColor[0] = "Black";
  SecondBandColor[1] = "Brown";
  SecondBandColor[2] = "Red";
  SecondBandColor[3] = "Orange";
  SecondBandColor[4] = "Yellow";
  SecondBandColor[5] = "Green";
  SecondBandColor[6] = "Blue";
  SecondBandColor[7] = "Violet";
  SecondBandColor[8] = "Gray";
  SecondBandColor[9] = "White";

  return SecondBandColor[oneholder];
}



}//class

  

 




