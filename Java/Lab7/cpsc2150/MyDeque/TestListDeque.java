//Rob Hughes
//Dante Stewart

package cpsc2150.MyDeque;

import org.junit.Test;

import static org.junit.Assert.*;



public class TestListDeque {

    // creating an IDeque to reference
    private IDeque<Character> MakeADeque(){
        return new ListDeque<Character>();
    }


    // ENQUEUE


    // enqueue test number 1
    @Test
    public void test_enqueue_abcd(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('a');
        md.enqueue('b');
        md.enqueue('c');

        md.enqueue('d');


        String actual= md.toString();

        assertEquals("<a, b, c, d>",actual);
    }

    // enqueue test number 2
    @Test
    public void test_enqueue_zyw(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('z');
        md.enqueue('y');

        md.enqueue('w');

        String actual= md.toString();

        assertEquals("<z, y, w>",actual);
    }

    // enqueue test number 3
    @Test
    public void test_enqueue_t(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('t');

        String actual= md.toString();

        assertEquals("<t>", actual);
    }


    // DEQUEUE


    // dequeue test number 1
    @Test
    public void test_dequeue_a_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('a');
        md.enqueue('b');
        md.enqueue('c');

        char expected1= 'a';
        char expected2 = 'b';

        char actual1 = md.dequeue();
        char actual2 = md.dequeue();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
    }

    // dequeue test number 2
    @Test
    public void test_dequeue_t_w_b_a_t(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('t');
        md.enqueue('w');
        md.enqueue('b');
        md.enqueue('a');
        md.enqueue('t');

        char expected1= 't';
        char expected2= 'w';
        char expected3= 'b';
        char expected4= 'a';
        char expected5= 't';

        char actual1= md.dequeue();
        char actual2= md.dequeue();
        char actual3= md.dequeue();
        char actual4= md.dequeue();
        char actual5= md.dequeue();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
        assertEquals(expected5, actual5);
    }

    // dequeue test number 3
    @Test
    public void test_dequeue_r(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('e');

        char expected1= 'r';

        char actual1= md.dequeue();

        assertEquals(expected1 , actual1);
    }


    // INJECT


    // inject test number 1
    @Test
    public void test_inject_robert(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('e');
        md.enqueue('r');
        md.enqueue('t');

        md.inject('r');

        String actual= md.toString();

        assertEquals("<r, o, b, e, r, t>", actual);
    }

    // inject test number 2
    @Test
    public void test_inject_y(){
        IDeque<Character> md= MakeADeque();

        md.inject('y');

        String actual= md.toString();

        assertEquals("<y>", actual);
    }

    // inject test number 3
    @Test
    public void test_inject_a(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('b');
        md.enqueue('c');
        md.enqueue('d');
        md.enqueue('e');
        md.enqueue('f');
        md.enqueue('g');

        md.inject('a');

        String actual= md.toString();

        assertEquals("<a, b, c, d, e, f, g>", actual);
    }


    // REMOVELAST


    // removeLast test number 1
    @Test
    public void test_removeLast_g(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('a');
        md.enqueue('b');
        md.enqueue('c');
        md.enqueue('d');
        md.enqueue('e');
        md.enqueue('f');
        md.enqueue('g');

        char expected1= 'g';

        char actual1= md.removeLast();

        assertEquals(expected1, actual1);
    }

    // removeLast test number 2
    @Test
    public void test_removeLast_z_a_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('z');
        md.enqueue('a');
        md.enqueue('b');

        char expected1= 'b';
        char expected2= 'a';
        char expected3= 'z';

        char actual1= md.removeLast();
        char actual2= md.removeLast();
        char actual3= md.removeLast();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // removeLast test number 3
    @Test
    public void test_removeLast_h(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('h');

        char expected1= 'h';

        char actual1= md.removeLast();

        assertEquals(expected1, actual1);
    }


    // CLEAR


    // clear test number 1
    @Test
    public void test_clear_roberth(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('e');
        md.enqueue('r');
        md.enqueue('t');
        md.enqueue('h');

        md.clear();

        String actual= md.toString();

        assertEquals("<>", actual);
    }

    // clear test number 2
    @Test
    public void test_clear_h(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('h');

        md.clear();

        String actual= md.toString();

        assertEquals("<>", actual);
    }

    // clear test number 3
    @Test
    public void test_clear_empty(){
        IDeque<Character> md= MakeADeque();

        md.clear();

        String actual= md.toString();

        assertEquals("<>", actual);
    }


    // PEEK


    // peek test number 1
    @Test
    public void test_peek_r(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');

        char expected1= 'r';

        char actual1= md.peek();


        assertEquals(expected1, actual1);
    }

    // peek test number 2
    @Test
    public void test_peek_d_a_e(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('d');
        md.enqueue('a');
        md.enqueue('n');
        md.enqueue('t');
        md.enqueue('e');

        char expected1= 'd';
        char expected2= 'a';
        char expected3= 'e';

        char actual1= md.peek();
        md.dequeue();
        char actual2= md.peek();
        md.dequeue();
        md.dequeue();
        md.dequeue();
        char actual3= md.peek();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // peek test number 3
    @Test
    public void test_peek_r_o_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('e');
        md.enqueue('r');

        char expected1= 'r';
        char expected2= 'o';
        char expected3= 'b';

        char actual1= md.peek();
        md.dequeue();
        char actual2= md.peek();
        md.dequeue();
        char actual3= md.peek();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }


    // ENDOFDEQUE


    // endOfDeque test number 1
    @Test
    public void test_endOfDeque_r_o_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('b');
        md.enqueue('o');
        md.enqueue('r');

        char expected1= 'r';
        char expected2= 'o';
        char expected3= 'b';

        char actual1= md.endOfDeque();
        md.removeLast();
        char actual2= md.endOfDeque();
        md.removeLast();
        char actual3= md.endOfDeque();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // endOfDeque test number 2
    @Test
    public void test_endOfDeque_h_b_r(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('e');
        md.enqueue('r');
        md.enqueue('t');
        md.enqueue('h');

        char expected1= 'h';
        char expected2= 'b';
        char expected3= 'r';

        char actual1= md.endOfDeque();
        md.removeLast();
        md.removeLast();
        md.removeLast();
        md.removeLast();
        char actual2= md.endOfDeque();
        md.removeLast();
        md.removeLast();
        char actual3= md.endOfDeque();

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // endOfDeque test number 3
    @Test
    public void test_endOfDeque_z(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('z');

        char expected1= 'z';

        char actual1= md.endOfDeque();

        assertEquals(expected1, actual1);
    }


    // INSERT

    // insert test number 1
    @Test
    public void test_insert_e(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('r');
        md.enqueue('t');
        md.enqueue('h');

        md.insert('e',4);

        String actual1= md.toString();

        assertEquals("<r, o, b, e, r, t, h>", actual1);
    }

    // insert test number 2
    @Test
    public void test_insert_d_n_e(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('d');
        md.enqueue('n');
        md.enqueue('e');

        md.insert('a',2);
        md.insert('t',4);

        String actual1= md.toString();

        assertEquals("<d, a, n, t, e>", actual1);
    }

    // insert test number 3
    @Test
    public void test_insert_r_o_b(){
        IDeque<Character> md= MakeADeque();

        md.insert('b',1);
        md.insert('o',1);
        md.insert('r',1);

        String actual1= md.toString();

        assertEquals("<r, o, b>", actual1);
    }


    // REMOVE


    // remove test number 1
    @Test
    public void test_remove_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('r');
        md.enqueue('t');
        md.enqueue('h');

        char expected1= 'b';

        char actual1= md.remove(3);

        assertEquals(expected1, actual1);
    }

    // remove test number 2
    @Test
    public void test_remove_a_t_e(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('d');
        md.enqueue('a');
        md.enqueue('n');
        md.enqueue('t');
        md.enqueue('e');

        char expected1= 'a';
        char expected2= 't';
        char expected3= 'e';

        char actual1= md.remove(2);
        char actual2= md.remove(3);
        char actual3= md.remove(3);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // remove test number 3
    @Test
    public void test_remove_z(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('z');

        char expected1= 'z';

        char actual1= md.remove(1);

        assertEquals(expected1, actual1);
    }


    // GET

    // get test number 1
    @Test
    public void test_get_b(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('r');
        md.enqueue('o');
        md.enqueue('b');
        md.enqueue('r');
        md.enqueue('t');
        md.enqueue('h');

        char expected1= 'b';

        char actual1= md.get(3);

        assertEquals(expected1, actual1);
    }

    // get test number 2
    @Test
    public void test_get_a_t_e(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('d');
        md.enqueue('a');
        md.enqueue('n');
        md.enqueue('t');
        md.enqueue('e');

        char expected1= 'a';
        char expected2= 't';
        char expected3= 'e';

        char actual1= md.get(2);
        char actual2= md.get(4);
        char actual3= md.get(5);

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    // get test number 3
    @Test
    public void test_get_z(){
        IDeque<Character> md= MakeADeque();

        md.enqueue('z');

        char expected1= 'z';

        char actual1= md.get(1);

        assertEquals(expected1, actual1);
    }
}

