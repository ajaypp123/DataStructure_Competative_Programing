
/**
 * Implement stack, instade top it return min element
 *
 *
 * push(2)  min 2
 * push(5)  min 2
 * push(1)  min 1
 * push(10) min 1
 * pop()    min 1
 * pop()    min 2
 * =============================
 *
 * store min value in min variable
 *
 * Push 5, 3
 * for min push = 2*x-min     pop =  min*2-1
 *
 *
 * 1    min 3   3*2-5
 * 5    min 5
 *
 * pop()    next min = min*2-a[top] = 3*2-1 = 5
 *
 */

public class StackMin {

}
