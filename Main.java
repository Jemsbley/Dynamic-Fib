import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

// Note: This could be made more efficient by storing the data from the file in an array so items can be accessed in O(1) time,
// Currently, it repeatedly loops through the file to read, which in large cases is still significantly faster than the non-dynamic programming
// instance, but notably slower than creating such a lookup table

class Main {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(fib(5));
    System.out.println(fib(5));
  }

  /**
  Determines if the fib nums file has an entry for the jth fibonacci number
  Returns that number if it found and -1 if there is no entry
  */
  public static long hasNum(int j) throws FileNotFoundException
  {
    File file = new File("fib nums.txt");
    Scanner sc = new Scanner(file);
    int count = 0;
    while (sc.hasNextLine())
      {
        count++;
        sc.nextLine();
      }
    sc = new Scanner(file);
    long[][] fileread = new long[count][2];
    for (int i = 0; i < count; i ++)
      {
        fileread[i][0] = sc.nextLong();
        fileread[i][1] = sc.nextLong();
      }
    sc.close();
    for (int i = 0; i < count; i++)
      {
        if (fileread[i][0] == j)
        {
          return fileread[i][1];
        }
      }
    return -1;
  }

  /**
  Adds the given input and fibonacci number associated with that input to the correct spot in the fib nums file
  */
  public static boolean addNum(int input, long fibin) throws FileNotFoundException
  {
    File read = new File("fib nums.txt");
    Scanner sc = new Scanner(read);
    int i = 0;
    ArrayList<String> ar = new ArrayList<String>();
    int check;
    while (sc.hasNextLine() && i < input)
      {
        check = sc.nextInt();
        if (check > input)
        {
          break;
        }
        i++;
        sc.nextLine();
      }
    sc = new Scanner(read);
    for (int j = 0; j < i; j++)
      {
        ar.add(sc.nextLine());
      }
    ar.add(input + " " + fibin);
    while(sc.hasNextLine())
      {
        ar.add(sc.nextLine());
      }
    sc.close();
    PrintWriter pw = new PrintWriter(read);
    for (int j = 0; j < ar.size(); j++)
      {
        pw.println(ar.get(j));
      }
    pw.close();
    return true;
  }

  /**
  Calculates the ith fibonacci number:
  First, it determines if the ith fib number has been previously calculated, and returns it if so.
  If the ith fib number has not been calculated, manually calculates it through recursion
  */
  public static long fib(int i) throws FileNotFoundException
  {
    final long startTime = System.currentTimeMillis();
    long num = hasNum(i);
    if (num == -1)
    {
      num =  fib(i-1) + fib(i-2);
      addNum(i,num);
      final long endTime = System.currentTimeMillis();
      System.out.println(i + ": " + (endTime-startTime));
      return num;
    }
    else
    {
      final long endTime = System.currentTimeMillis();
      System.out.println(i + ": " + (endTime-startTime));
      return num;
    }
  }
}
