/* Trivia
 * Player.java
 * Zhiyan Zhong
 */
public class Player{ 

  String name;
  int score;
  
  static int numberOfPlayers = 0;
  
  public Player(String n) {
    name = n;
    score = 0;
    numberOfPlayers++;
  }
  
  public String toString() {
    String result = "Name: "+name+"   Score: "+score;
    return result;
  
  }

}
