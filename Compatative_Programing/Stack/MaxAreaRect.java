
/*
    0 1 1 0
    1 1 1 1
    1 1 1 1
    1 1 0 0

Max area = 4*2 = 8
     0 1 1 0
    --------
   | 1 1 1 1 |
   | 1 1 1 1 |
    --------
     1 1 0 0

=======================

Solution:
Devide problem into 4 histogram

            0 1 1 0
    i=0    ----------

            1 2 2 1
    i=1     ---------

            2 3 3 2             == > 2*4 = 8
    i=2     ---------

            3 3 0 0
    i=3     ---------


    Max area = Max(max_histogram(i=0to4))

*/


public class MaxAreaRect {

}
