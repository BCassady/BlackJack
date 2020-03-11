import java.util.*;

class Main {
  public static void main(String[] args) {
      BlackJack obj = new BlackJack();
      obj.PlayGame();
  }
}
class BlackJack {
    BlackJack(){
    }
    public void PlayGame(){
        int Balance = 1000;
    while(true){
        Scanner sc = new Scanner(System.in);
        System.out.println("Current Balance: " + Balance);
        System.out.println("What would you like to bet?");
        boolean betMade = false;
        int Bet = sc.nextInt();
        while(betMade==false){
             if(Bet>Balance){
                 System.out.println("You must make a bet in your balance, place a new bet");
                 Bet = sc.nextInt();
             } else {
                 betMade = true;
             }
        }
       
    ArrayList<String> Cards = new ArrayList<String>();
    Cards.add("Two");
    Cards.add("Three");
    Cards.add("Four");
    Cards.add("Five");
    Cards.add("Six");
    Cards.add("Seven");
    Cards.add("Eight");
    Cards.add("Nine");
    Cards.add("Ten");
    Cards.add("Jack");
    Cards.add("Queen");
    Cards.add("King");
    Cards.add("Ace");
    ArrayList<Integer> Numbers = new ArrayList<Integer>();
    Numbers.add(2);
    Numbers.add(3);
    Numbers.add(4);
    Numbers.add(5);
    Numbers.add(6);
    Numbers.add(7);
    Numbers.add(8);
    Numbers.add(9);
    Numbers.add(10);
    Numbers.add(10);
    Numbers.add(10);
    Numbers.add(10);
    Numbers.add(11);
    int PlayerTotal = 0;
    int PlayerCard1 = -1;
    int PlayerCard2 = -1;
    int PlayerCard3 = -1;
    PlayerCard1 = (int)(Math.random()*13);
    PlayerCard2 = (int)(Math.random()*13);
    PlayerTotal = Numbers.get(PlayerCard1) + Numbers.get(PlayerCard2);
    System.out.println("Your Cards are " + Cards.get(PlayerCard1) + " and " + Cards.get(PlayerCard2));
    System.out.println("Would you like to hit or stay? (0 or 1)");
    int choice = sc.nextInt();
    boolean acePresent = false;
    boolean busted2 = false;
    boolean busted = false;
    boolean dontHit = false;
    if(choice==0){
        while(dontHit==false&&busted2==false){
        PlayerCard3 = (int)(Math.random()*13);
        PlayerTotal += Numbers.get(PlayerCard3);
        System.out.println("You drew a " + Cards.get(PlayerCard3));
        if(PlayerTotal>20){
            busted2 = true;
            break;
        }
        System.out.println("Would you like to hit or stay? (0 or 1)");
        choice = sc.nextInt();
        if(choice==1){
            dontHit=true;
        }
        }
        if(PlayerCard1==12||PlayerCard2==12||PlayerCard3==12){
            acePresent = true;
        }
        if(PlayerTotal>21){
            if(acePresent==true){
                if((PlayerTotal-10)==21){
                    System.out.println("Blackjack!");
                } else {
                System.out.println("Your total was " + (PlayerTotal-10));
                }
            } else {
            System.out.println("Busted!");
            busted = true;
            }
        } else if (PlayerTotal==21){
            System.out.println("Blackjack!");
        } else {
            System.out.println("Your total was " + PlayerTotal);
        }
    } else {
         if(PlayerTotal==21){
            System.out.println("Blackjack!");
        } else if (PlayerTotal>21){
            System.out.println("Your total was " + (PlayerTotal-10));
        } else {
            System.out.println("Your total was " + PlayerTotal);
        }
    }
    int DealerTotal = 0;
    int DealerCard = -1;
    if(busted==true){
        System.out.println("Dealer Wins!");
        Balance -= Bet;
    }else{
        while(DealerTotal<17){
            DealerCard = (int)(Math.random()*13);
            System.out.println("Dealer's Card: " + Cards.get(DealerCard));
            DealerTotal += Numbers.get(DealerCard);
        }
        if(DealerTotal>21){
            System.out.println("Dealer Busts, You Win!");
            Balance += Bet;
        } else if (DealerTotal<PlayerTotal){
            System.out.println("Dealer's total was " + DealerTotal + ", You Win!");
            Balance += Bet;
        } else if (DealerTotal>PlayerTotal){
            System.out.println("Dealer's total was " + DealerTotal + ", You Lose!");
            Balance -= Bet;
        } else {
            System.out.println("Dealer's total was " + DealerTotal + ", Tie!");
        }
    }
    System.out.println("New Balance: " + Balance);
    if (Balance==0){
        break;
    }
    System.out.println("Press 0 to continue, any other number to quit");
    if(sc.nextInt()!=0){
        break;
    }
    }
    }
}