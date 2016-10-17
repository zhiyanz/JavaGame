
import java.io.*;
import java.util.Scanner;
public class TriviaBoard 
{
  String category;
  Scanner questionScan;
  Scanner answerScan;
  static String[] question = new String[12]; 
  static String[] answer = new String[12];
  
  public TriviaBoard(String cat) throws IOException { 
    TriviaGame2.categories.remove(cat);
    
    category = cat;
   
    if (category.equals("country")){
      questionScan = new Scanner(new File("CountryQuestions.txt"));
      answerScan = new Scanner(new File("CountryAnswers.txt"));
    }
    else if (category.equals("music")) {
      questionScan = new Scanner(new File("MusicQuestions.txt"));
      answerScan = new Scanner(new File("MusicAnswers.txt"));
    }
    else if (category.equals("history")) {
      questionScan = new Scanner(new File("HistoryQuestions.txt"));
      answerScan = new Scanner(new File("HistoryAnswers.txt"));
    }
    else if (category.equals("science"))
    {
      questionScan = new Scanner(new File("ScienceQuestions.txt"));
      answerScan = new Scanner(new File("ScienceAnswers.txt"));
    }
    
    for (int i=0; i<12; i++)
    {
      question[i]=questionScan.nextLine();
      answer[i]=answerScan.nextLine();
    }
  }
  

  public  void playGame(Player[] order) throws IOException
  {
    File inputFile = new File("trivialog.txt");
    PrintWriter printWriter = new PrintWriter(inputFile);
    Scanner keyboard = new Scanner(System.in);
    
    int questionNum = 0; 
    int answerNum = 0; 
    while (questionNum < 12) {
      for (int i = 0; i<order.length; i++) {
        System.out.println("Player "+(i+1)+"'s turn: "+order[i]);
        System.out.println("Question: "+ question[questionNum]);
        System.out.print("Player "+(i+1)+"'s answer: ");
        String input = keyboard.nextLine();
        order[i].score = search(answer, input,order[i].score); 
        System.out.println("Score: " +order[i].score);
        printWriter.println("Player: " +(i+1) + order[i]);
        printWriter.println("Score: " + order[i].score);
        
        questionNum++;
        answerNum++;   
        printWriter.close();
      }
    }
    rank(order);
  }
  public static int search(String[] answer, String input, int score) 
  {
    boolean correctAnswer = false; 
    for (int i = 0; i <answer.length; i++)
    {
      if (input.equalsIgnoreCase(answer[i]))
      {
        correctAnswer = true;
        score++;
        break;
      }
    }
    return score;
  }
 
  public static void rank (Player [] score) 
  {
    for(int i = 0; i<score.length; i++)
    {
      for (int j = 0; j<score.length; j++)
      {
        if (score[j].score<score[i].score)
        {
          Player temp = score[j];
          score[j] = score[i];
          score[i] = temp; 
        }
      }
    }
    for (int i=0; i<score.length; i++)
      System.out.println(score[i]);
  }
}
    
    
    