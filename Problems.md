```java
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 7; page ??
// Can be run from command line
// See TriTyp.num for a numbered version.
// No JUnit tests at this time.

import java.io.*;

public class TriTyp
{
   private static String[] triTypes = { "", // Ignore 0.
      "scalene", "isosceles", "equilateral", "not a valid triangle"};
   private static String instructions = "This is the ancient TriTyp program.\nEnter three integers that represent the lengths of the sides of a triangle.\nThe triangle will be categorized as either scalene, isosceles, equilateral\nor invalid.\n";

public static void main (String[] argv)
{  // Driver program for TriTyp
   int A, B, C;
   int T;

   System.out.println (instructions);
   System.out.println ("Enter side 1: ");
   A = getN();
   System.out.println ("Enter side 2: ");
   B = getN();
   System.out.println ("Enter side 3: ");
   C = getN();
   T = triang (A, B, C);

   System.out.println ("Result is: " + triTypes[T]);
}

// ====================================
// The main triangle classification method
private static int triang (int Side1, int Side2, int Side3)
{
   int triOut;

   // triOut is output from the routine:
   //    triang = 1 if triangle is scalene
   //    triang = 2 if triangle is isosceles
   //    triang = 3 if triangle is equilateral
   //    triang = 4 if not a triangle

   // After a quick confirmation that it's a valid
   // triangle, detect any sides of equal length
   if (Side1 <= 0 || Side2 <= 0 || Side3 <= 0)
   {
      triOut = 4;
      return (triOut);
   }

   triOut = 0;
   if (Side1 == Side2)
      triOut = triOut + 1;
   if (Side1 == Side3)
      triOut = triOut + 2;
   if (Side2 == Side3)
      triOut = triOut + 3;
   if (triOut == 0)
   {  // Confirm it's a valid triangle before declaring
      // it to be scalene

     if (Side1+Side2 <= Side3 || Side2+Side3 <= Side1 ||
        Side1+Side3 <= Side2)
        triOut = 4;
     else
        triOut = 1;
     return (triOut);
   }

   // Confirm it's a valid triangle before declaring
   // it to be isosceles or equilateral

   if (triOut > 3)
      triOut = 3;
   else if (triOut == 1 && Side1+Side2 > Side3)
      triOut = 2;
   else if (triOut == 2 && Side1+Side3 > Side2)
      triOut = 2;
   else if (triOut == 3 && Side2+Side3 > Side1)
      triOut = 2;
   else
      triOut = 4;
   return (triOut);
} // end Triang

// ====================================
// Read (or choose) an integer
private static int getN ()
{
   int inputInt = 1;
   BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
   String inStr;

   try
   {
      inStr    = in.readLine ();
      inputInt = Integer.parseInt(inStr);
   }
   catch (IOException e)
   {
      System.out.println ("Could not read input, choosing 1.");
   }
   catch (NumberFormatException e)
   {
      System.out.println ("Entry must be a number, choosing 1.");
   }

   return (inputInt);
}  // end getN

}  // end TriTyp class
```



### Problems

#### 1.

**Predicates:**

42: (Side1 <= 0 || Side 2 <= 0 || Side3 <= 0)

49: (Side1 == Side2)

51: (Side1 == Side3)

53: (Side2 == Side3)

55: (triOut == 0)

59: (Side1 + Side2 <= Side 3 || Side 2 + Side3 <= Side1 || Side1 + Side3 <= Side2)

70: (triOut > 3)

72: (triOut == 1 && Side1 + Side2 > Side3)

74: (triOut == 2 && Side1 + Side3 > Side2)

76: (triOut == 3 && Side2 + Side3 > Side1)



#### 2.

**Reachability:**

42: True

49: S1 > 0 && S2 > 0 && S3 > 0

51: S1 > 0 && S2 > 0 && S3 > 0

53: S1 > 0 && S2 > 0 && S3 > 0

55: S1 > 0 && S2 > 0 && S3 > 0

59: S1 > 0 && S2 > 0 && S3 > 0 && triOut = 0

62: S1 > 0 && S2 > 0 && S3 > 0 && triOut = 0 && (S1 + S2 > S3) && (S2 + S3 > S1) && (S1 + S3 > S2)

70: S1 > 0 && S2 > 0 && S3 > 0 && triOut != 0

72: S1 > 0 && S2 > 0 && S3 > 0 && triOut != 0 && triOut <= 3

74: S1 > 0 && S2 > 0 && S3 > 0 && triOut != 0 && triOut <= 3 && (triOut != 1 || S1 + S2 <= S3)

76: S1 > 0 && S2 > 0 && S3 > 0 && triOut != 0 && triOut <= 3 && (triOut != 1 || S1 + S2 <= S3) && (triOut != 2 || S1 + S3 <= S2)

78: S1 > 0 && S2 > 0 && S3 > 0 && triOut != 0 && triOut <= 3 && (triOut != 1 || S1 + S2 <= S3) && (triOut != 2 || S1 + S3 <= S2) && (triOut != 3 || S2 + S3 <= S1)



#### 3.

**Internal Variables**

triOut = 0 when S1 != S2 && S2 != S3 && S1 != S3

triOut = 1 when S1 == S2 && S2 != S3 && S1 != S3

triOut = 2 when S1 != S2 && S2 != S3 && S1 == S3

triOut = 3 when S1 != S2 && S2 == S3 && S1 != S3

triOut = 4 when S1 == S2 && S2 == S3 && S1 != S3

triOut = 5 when S1 != S2 && S2== S3 && S1 == S3

triOut = 6 when S1 == S2 && S2 == S3 && S1 == S3



#### 4.

**Reduced Reachability**

42: True

49: S1 > 0 && S2 > 0 && S3 > 0

51: S1 > 0 && S2 > 0 && S3 > 0

53: S1 > 0 && S2 > 0 && S3 > 0

55: S1 > 0 && S2 > 0 && S3 > 0

59: P1 = S1 > 0 && S2 > 0 && S3 > 0 && S1 != S2 && S2 != S3 && S1 != S3

62: S1 > 0 && S2 > 0 && S3 > 0 && S1 != S2 && S2 != S3 && S1 != S3 && (S1 + S2 > S3) && (S2 + S3 > S1) && (S1 + S3 > S2)

70: S1 > 0 && S2 > 0 && S3 > 0 && P2 =（S1 == S2 || S2 == S3 || S1 == S3)

72: P1 && P2 && P3 = (S1 != S2 || S2 != S3 || S1 != S3)

74: P1 && P2 && P3 && (S1 != S2 || S1 + S2 <= S3)

76: P1 && P2 && P3 && (S1 != S2 || S1 + S2 <= S3) && (S1 != S3 || S1 + S3 <= S2)

78: P1 && P2 && P3 && (S1 != S2 || S1 + S2 <= S3) && (S1 != S3 || S1 + S3 <= S2) && (S2 != S3 || S2 + S3 <= S1)



#### 5.

**PC**

| Predicate                                 |  A   |  B   |  C   |  EO  |  A   |  B   |  C   |  EO  |
| :---------------------------------------- | :--: | :--: | :--: | :--: | :--: | :--: | :--: | :--: |
| S1<=0 \|\| S2<=0 \|\| S3<=0               |  0   |  0   |  0   |  4   |  1   |  1   |  1   |  3   |
| S1 == S2                                  |  1   |  1   |  1   |  3   |  1   |  2   |  2   |  3   |
| S1 == S3                                  |  1   |  1   |  1   |  3   |  1   |  2   |  2   |  2   |
| S2 == S3                                  |  1   |  1   |  1   |  3   |  2   |  1   |  2   |  2   |
| triOut == 0                               |  1   |  2   |  3   |  4   |  1   |  1   |  1   |  3   |
| (S1+S2<=S3 \|\| S2+S3<=S1 \|\| S1+S3<=S2) |  1   |  2   |  3   |  4   |  2   |  3   |  4   |  1   |
| triOut>3                                  |  1   |  1   |  1   |  3   |  2   |  2   |  3   |  2   |
| (triOut==1 && S1+S2>S3)                   |  2   |  2   |  3   |  2   |  2   |  2   |  4   |  4   |
| (triOut==2 && S1+S3>S2)                   |  2   |  3   |  2   |  2   |  2   |  4   |  2   |  4   |
| (triOut==3 && S2+S3>S1)                   |  3   |  2   |  2   |  2   |  4   |  2   |  2   |  4   |



#### 6.

**CC**



| Prediate  | A    | B    | C    | EO   | A    | B    | C    | EO   |
| --------- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| S1<=0     | 0    | 1    | 1    | 4    | 1    | 1    | 1    | 3    |
| S2<=0     | 1    | 0    | 1    | 4    | 1    | 1    | 1    | 3    |
| S3<=0     | 1    | 1    | 0    | 4    | 1    | 1    | 1    | 3    |
| S1+S2<=S3 | 2    | 3    | 6    | 4    | 2    | 3    | 4    | 1    |
| S2+S3<=S1 | 6    | 2    | 3    | 4    | 2    | 3    | 4    | 1    |
| S1+S3<=S2 | 2    | 6    | 3    | 4    | 2    | 3    | 4    | 1    |
| triOut==1 | 2    | 2    | 3    | 2    | 2    | 3    | 2    | 2    |
| S1+S2>S3  | 2    | 2    | 3    | 2    | 2    | 2    | 5    | 4    |
| triOut==2 | 2    | 3    | 2    | 2    | 2    | 4    | 2    | 4    |
| S1+S3>S2  | 2    | 3    | 2    | 2    | 2    | 5    | 2    | 4    |
| triOut==3 | 3    | 2    | 2    | 2    | 1    | 2    | 1    | 4    |
| S2+S3>S1  | 3    | 2    | 2    | 2    | 5    | 2    | 2    | 4    |



#### 7.

**CACC**

| Predicate | Clauses | Clauses | Clauses |  A   |  B   |  C   |  EO  |
| --------- | :-----: | :-----: | :-----: | :--: | :--: | :--: | :--: |
| S1<=0     |    T    |    F    |    F    |  0   |  1   |  1   |  4   |
| S2<=0     |    F    |    F    |    F    |  1   |  1   |  1   |  3   |
| S3<=0     |    F    |    T    |    F    |  1   |  0   |  1   |  4   |
|           |    F    |    F    |    T    |  1   |  1   |  0   |  4   |
| S1+S2<=S3 |    T    |    F    |    F    |  2   |  3   |  6   |  4   |
| S2+S3<=S1 |    F    |    F    |    F    |  2   |  3   |  4   |  1   |
| S1+S3<=S2 |    F    |    T    |    F    |  6   |  2   |  3   |  4   |
|           |    F    |    F    |    T    |  2   |  6   |  3   |  4   |
| triOut==1 |    T    |    F    |    -    |  2   |  2   |  3   |  2   |
| S1+S2>S3  |    F    |    T    |    -    |  2   |  3   |  3   |  2   |
|           |    T    |    F    |    -    |  2   |  2   |  5   |  4   |
| triOut==2 |    T    |    T    |    -    |  2   |  3   |  2   |  2   |
| S1+S3>S2  |    F    |    T    |    -    |  2   |  3   |  3   |  2   |
|           |    T    |    F    |    -    |  2   |  5   |  2   |  4   |
| triOut==3 |    T    |    T    |    -    |  3   |  2   |  2   |  2   |
| S2+S3>S1  |    F    |    T    |    -    |  3   |  6   |  3   |  4   |
|           |    T    |    F    |    -    |  5   |  2   |  2   |  4   |

