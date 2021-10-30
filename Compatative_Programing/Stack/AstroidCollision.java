

/*

Find out the state of the asteroids after all collisions.

If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Input: asteroids = [-2,-1,1,2]
Output: [-2,-1,1,2]
Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right. Asteroids moving the same direction never meet, so no asteroids will meet each other.

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

=============================================================

4 possibility
  --> <---
  +    -

  ---> --->
   +    +

   <--- <---
    -    -

    <--- --->
    -     +


Collision can only happens in ---> <---

    traverse to stack
        if no collision push in stack
        if collision
            While (stack empty or no collision with top)
                if(top > curr)
                    // curr destroyed break loop


*/

public class AstroidCollision {

}
