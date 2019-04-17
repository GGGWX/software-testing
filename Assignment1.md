## Ch1 Ex5

**findLast()**

- `for(int i=x.length-1; i>0; i--)` should be `for(int i=x.length-1; i>=0; i--)`
- let x=[2, 3, 5], y = 5, then Expected = 2 and Actual = 2
- let x=[2, 2, 5], y = 2, then Expected = 0 and Actual = 1
- let x= [] , y = any integer, then there will throw a NullPointerException
- the first error state: the loop can not reach index of 0. And the following error state is that the actual answer does not match with the expected answer.
- ![](/Users/gggwx/Desktop/屏幕快照 2019-02-25 下午8.23.36.png)

**lastZero()**

- `for(int i=0; i<x.length; i++)` should be `for(int i=x.length-1; i>=0; i--)`
- any case will cause the fault, because the code is defective
- any input results in error
- let x = [1, 0, 2], then Expected = 1 and Actual = 1
- the first error state: int i=0. 
- ![](/Users/gggwx/Desktop/屏幕快照 2019-02-25 下午8.30.58.png)

**countPositive()**

- `for(int i=0; i<x.length; i++)` should be `for(int i=0; i<x.length-1; i++)` and`if(x[i] >= 0)` should be `if(x[i] > 0)`
- any case will execute the fault, which will cause index out of bounds
- any case will
- any case except x is null will result in an error but not failure
- the first error state: the loop counter is incorrect. And the comparison to zero is also errorenous.
- ![](/Users/gggwx/Desktop/屏幕快照 2019-02-25 下午9.06.08.png)

**oddOrPos()**

- `if(x[i]%2 == 1 || x[i] > 0)` should be `if(x[i]%2 == -1 || x[i] > 0)`
- let x = [], then Expected = 0 and Actual = 0
- let x = [1, 2, 3], then Expected = 3 and Actual = 3
- when a case raises an error, it will simultaneously result in a failure.
- the first error state: -3 is not considered as an odd number.
- ![](/Users/gggwx/Desktop/屏幕快照 2019-02-25 下午9.05.11.png)



## Ch3 Ex5

- The **assertTrue()** only checks a part of the final state. So if a test case causes infection then propagation to another part of the final state, the failure will not be observed.![RIPR](/Users/gggwx/Downloads/QQ20190226-0.png)



## Ch3 Ex6

![](/Users/gggwx/Desktop/WX20190226-213640@2x.png)

- computePrimes(1)
- i dont know
- cannot be created because when the state changes, the final state will also change
- computePrimes(8), which will omit 19
- `computePrimes(8); System.out.println(primes);`