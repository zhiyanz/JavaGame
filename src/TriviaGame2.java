
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class TriviaGame2
{
  static Player player1 = null, player2 = null, player3 = null, player4 = null;
  static ArrayList<String> categories = new ArrayList<>(); 
  static TriviaBoard board = null;
  
  public static void main(String[] args) throws IOException
  {
    categories.add("country");
    categories.add("science");
    categories.add("music");
    categories.add("history");
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Do you want instructions?"); 
    String answer = scan.nextLine();
    
    if (answer.equals("yes")) 
    { 
      File instructions = new File("Instructions.txt");
      Scanner instructionsRead = new Scanner(instructions);  
      while (instructionsRead.hasNextLine()) 
      {
        String x = instructionsRead.nextLine(); 
        System.out.println(x);
      }
      instructionsRead.close();
    }
    else 
    { 
      System.out.println("Okay. Good luck!");
    }
    
    getNumOfPlayers(scan);
    scan.nextLine();
    
    Player[] order = getOrderOfPlayers();
    
    while(categories.size()!=0) {
      System.out.println("Order of players are:");
      for(int i = 0; i<order.length; i++) {
        System.out.println((i+1)+": "+order[i]);
      }
      
      System.out.println("First player can choose categories");
      System.out.println(order[0]);
      
      String category = scan.nextLine();
      if (category.equalsIgnoreCase("country")) {
        board = new TriviaBoard("country");
      }
      else if (category.equalsIgnoreCase("music"))
      {
        board = new TriviaBoard("music");
        
      }
      else if (category.equalsIgnoreCase("history"))
      {
        board = new TriviaBoard("history");
      }
      else if (category.equalsIgnoreCase("science"))
      {
        board = new TriviaBoard("science");
      }
      
      
      board.playGame(order);
      
    }
    
  } 
  
  
  
  public static void getNumOfPlayers(Scanner scan) { 
    String name1, name2, name3, name4;
    
    System.out.println("How many players do you have?");
    int num = scan.nextInt();
    while (true)
      if (num == 1)
    {
      System.out.println("Need more players");
      num = scan.nextInt();
    }
    else if(num == 2)
    {
      System.out.println("What is Player1's name?");
      name1= scan.next();
      player1 = new Player(name1);
      System.out.println("What is Player2's name?");
      name2 = scan.next();
      player2 = new Player(name2);
      
      break;
    }
    else if(num == 3)
    {
      System.out.println("What is Player1's name?");
      name1 = scan.next();
      player1 = new Player(name1);
      System.out.println("What is Player2's name?");
      name2 = scan.next();
      player2 = new Player(name2);
      System.out.println("What is Player3's name?");
      name3 = scan.next();
      player3 = new Player(name3);
      
      break;
    }
    else if(num == 4)
    {
      System.out.println("What is Player1's name?");
      name1 = scan.next();
      player1 = new Player(name1);
      System.out.println("What is Player2's name?");
      name2 = scan.next();
      player2 = new Player(name2);
      System.out.println("What is Player3's name?");
      name3 = scan.next();
      player3 = new Player(name3);
      System.out.println("What is Player4's name?");
      name4 = scan.next();
      player4 = new Player(name4);
      
      break;
    }
    else
    {
      System.out.println("Sorry! Too many players!");
      num = scan.nextInt();
    }
  }
  
  public static Player[] getOrderOfPlayers() { 
    Player[] order = null;
    
    Random random = new Random(); 
    if (Player.numberOfPlayers == 2)
    { 
      order = new Player[2];
      int playersRandom = random.nextInt(2)+1;
      if (playersRandom == 1)
      { 
        order[0] = player1;
        order[1] = player2;
      }
      else if (playersRandom == 2)
      {
        order[0] = player2;
        order[1] = player1;
      }
    }
    if (Player.numberOfPlayers == 3)
    {
      order = new Player[3];
      int playersRandom = random.nextInt(3)+1;
      if (playersRandom == 1)
      {
        order[0] = player1;
        order[1] = player2;
        order[2] = player3;
      }
      else if (playersRandom == 2)
      {
        order[0] = player2;
        order[1] = player1;
        order[2] = player3;
      }
      else if (playersRandom == 3)
      {
        order[0] = player3;
        order[1] = player1;
        order[2] = player2;
      }
    }
    if (Player.numberOfPlayers == 4)
    {
      order = new Player[4];
      int playersRandom = random.nextInt(4)+1;

      if (playersRandom == 1)
      {
        order[0] = player1;
        order[1] = player2;
        order[2] = player3;
        order[3] = player4;
      }
      else if (playersRandom == 2)
      {
        order[0] = player2;
        order[1] = player3;
        order[2] = player4;
        order[3] = player1;
      }
      else if (playersRandom == 3)
      {
        order[0] = player3;
        order[1] = player4;
        order[2] = player1;
        order[3] = player2;
      }
      else if (playersRandom == 4)
      {
        order[0] = player4;
        order[1] = player1;
        order[2] = player2;
        order[3] = player3;
      }
    }
    
    return order;
  }
  
}