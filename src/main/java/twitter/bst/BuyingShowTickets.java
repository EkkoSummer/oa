package twitter.bst;

/**
 * There are n people standing in line to buy show tickets.Due to high demand, the venue sells tickets according to the following rules:
 *
 * The person at the head of the line can buy exactly one ticket and must then exit the line.
 * if a person needs to purchase additional tickets,they must re-enter the end of the line and wait to be sold their next ticket(assume exit and re-entry takes zero seconds).
 * Each ticket sale takes exactly one second.
 * We express initial line of n people as an array, tickets = [tickets0, tickets1 … ticketsN-1], where ticketsi denotes the number of tickets person i wishes to buy.
 * If Jesse is standing at a position p in this line, find out how much time it would take for him to buy all tickets. Complete the waiting time function in the editor below. It has two parameters:
 *
 * An array, tickets, of n positive integers describing initial sequence of people standing in line. Each ticketsi describes number of tickets that a person waiting at initial place.
 * An integer p, denoting Alex’s position in tickets.
 *
 * Sample Input 5 2 6 3 4 5
 * 2
 * Sample Output
 * 12
 * Sample Input 4 5 5 2 3
 * 3
 * Sample Output
 * 11
 */
public class BuyingShowTickets {

    public static void main(String[] args) {
        int[] tickets = {2,6,3,4,5};
        int p = 2;
        System.out.println(waitingTime(tickets, p));
    }

    public static long waitingTime(int[] tickets, int p){
        long ret = 0;
        int target = tickets[p];
        for(int i=0; i<=p; i++){
            if(tickets[i]<target){
                ret += tickets[i];
            }else{
                ret += target;
            }
        }
        for(int i=p+1; i<tickets.length; i++){
            if(tickets[i]<target){
                ret += tickets[i];
            }else{
                ret += target - 1;
            }
        }
        return ret;
    }
}
