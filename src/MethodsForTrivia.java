import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class MethodsForTrivia 
{
  String error, name1, name2, name3, name4;
  int players;
  public void display(String name1)
  {
    if (players == 1)
     System.out.println("Need more players");
  }
  public void display (String name1, String name2)
  { 
        System.out.println(name1);
        System.out.println(name2);
    
  }
  public void display (String name1, String name2, String name3)
  {
      System.out.println(name1);
      System.out.println(name2);
      System.out.println(name3);
  }
    
  public void display (String name1, String name2, String name3, String name4)
  {
      
       System.out.println(name1);
       System.out.println(name2);
       System.out.println(name3);
       System.out.println(name4);
      
    }

  public void country() throws IOException  
  {
   String countryAnswer;
   Scanner questionScan =new Scanner(new File("CountryQuestions.txt"));
   Scanner answerScan = new Scanner(new File("CountryAnswers.txt"));
   String[] question = new String[5];
   String[] answer = new String[5];
 for (int i=0; i<5; i++)
    {
      question[i]=questionScan.next();
      answer[i]=answerScan.next();
    }
  }
}

