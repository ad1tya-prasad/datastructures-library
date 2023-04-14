import mylib.datastructures.linear.SLL;
import mylib.datastructures.nodes.SNode;

import mylib.datastructures.linear.DLL;
import mylib.datastructures.nodes.DNode;

import mylib.datastructures.linear.CSLL;

import mylib.datastructures.linear.CDLL;

import mylib.datastructures.linear.StackLL;
import mylib.datastructures.linear.QueueLL;

import mylib.datastructures.nodes.TNode;
import mylib.datastructures.trees.AVL;

import mylib.datastructures.trees.BST;
import mylib.datastructures.nodes.SNode;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Main {
    /** Testing SLL **/
    @Test
    public void testSLLInsertHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testSLLInsertTail() {
        SLL sll = new SLL();
        sll.insertTail(new SNode(1));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test
    public void testSLLInsert() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);

        sll.insert(new SNode(3), 1);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 2);

        sll.insert(new SNode(2), 1);
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSLLInsertWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), -1);
    }

    @Test
    public void testSLLSortedInsert() {
        SLL sll = new SLL();
        sll.sortedInsert(new SNode(2));
        sll.sortedInsert(new SNode(1));
        sll.sortedInsert(new SNode(3));
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 3);
        assertEquals(sll.getSize(), 3);
    }

    @Test
    public void testSLLSearch() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        sll.insertHead(node1);
        sll.insertTail(node2);
        assertEquals(sll.search(node1), node1);
        assertEquals(sll.search(node2), node2);
        assertNull(sll.search(new SNode(3)));
    }

    @Test(expected = NullPointerException.class)
    public void testSLLDeleteHeadWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteHead();
    }

    @Test
    public void testSLLDeleteHead() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteHead();
        assertEquals(sll.getHead().value, 1);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testSLLDeleteTailWithEmptyList() {
        SLL sll = new SLL();
        sll.deleteTail();
    }
    @Test
    public void testSLLDeleteTail() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertHead(new SNode(2));
        sll.deleteTail();
        assertEquals(sll.getHead().value, 2);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSLLDeleteWithInvalidIndex() {
        SLL sll = new SLL();
        sll.insert(new SNode(1), 0);
        sll.delete(new SNode(1)); // delete the node with value 1
    }

    @Test
    public void testSLLDelete() {
        SLL sll = new SLL();
        SNode node1 = new SNode(1);
        sll.insert(node1, 0);
        sll.insert(new SNode(2), 1);
        sll.insert(new SNode(3), 2);
        sll.delete(node1); // delete the node with value 1
        assertEquals(1, sll.getHead().value);
        assertEquals(3, sll.getTail().value);
        assertEquals(2, sll.getSize());
    }

    @Test
    public void testSLLReverse() {
        SLL sll = new SLL();
        sll.insertHead(new SNode(1));
        sll.insertTail(new SNode(2));
        sll.insertTail(new SNode(3));
        sll.reverse();
        assertEquals(sll.getHead().value, 3);
        assertEquals(sll.getTail().value, 1);
        assertEquals(sll.getSize(), 3);
    }


    /** Testing DLL **/
    @Test
    public void testDLLInsert() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Insert at position
        DNode node4 = new DNode(4);
        dll.insert(node4, 1);
        assertEquals(4, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node1, node2.next);
        assertEquals(node4, node1.next);
        assertEquals(node2, node4.prev);
        assertEquals(node1, node3.prev);
    }

    @Test
    public void testDLLDelete() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node3);
        dll.insertHead(node2);
        dll.insertHead(node1);
        assertEquals(3, dll.getSize());

        // Delete head
        dll.deleteHead();
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Delete tail
        dll.deleteTail();
        assertEquals(1, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node2, dll.getTail());

        // Delete at position
        dll.delete(node2);
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());

        // Test deleting from empty list
        try {
            dll.deleteHead();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // Test passed
        }
    }

    @Test
    public void testDLLIsSorted() {
        DLL dll = new DLL();

        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        dll.insertHead(node3);
        dll.insertHead(node1);
        dll.insertHead(node2);
        assertFalse(dll.isSorted());

        dll.sort();
        assertTrue(dll.isSorted());
    }

    @Test
    public void testDLLSearch() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        dll.insertHead(node1);
        assertEquals(node1, dll.search(node1));
        assertEquals(node2, dll.search(node2));
        assertNull(dll.search(new DNode(3)));
    }

    @Test
    public void testDLLSort() {
        DLL dll = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        dll.insertHead(node3);
        dll.insertHead(node1);
        dll.insertHead(node2);
        dll.insertTail(node4);

        dll.sort();
        assertEquals(node1, dll.getHead());
        assertEquals(node2, node1.next);
        assertEquals(node3, node2.next);
        assertEquals(node4, dll.getTail());
        assertTrue(dll.isSorted());
    }
    @Test
    public void testDLLInsertAndClear() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Insert at position
        DNode node4 = new DNode(4);
        dll.insert(node4, 1);
        assertEquals(4, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());
        assertEquals(node1, node2.next);
        assertEquals(node4, node1.next);
        assertEquals(node2, node4.prev);
        assertEquals(node1, node3.prev);

        // Clear the list
        dll.clear();
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());

        // Insert after clear
        DNode node5 = new DNode(5);
        dll.insertHead(node5);
        assertEquals(1, dll.getSize());
        assertEquals(node5, dll.getHead());
        assertEquals(node5, dll.getTail());
    }

    @Test
    public void testDLLSequenceOfInsertsAndDeletes() {
        DLL dll = new DLL();
        assertEquals(0, dll.getSize());

        // Insert into empty list
        DNode node1 = new DNode(1);
        dll.insertHead(node1);
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at head
        DNode node2 = new DNode(2);
        dll.insertHead(node2);
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Insert at tail
        DNode node3 = new DNode(3);
        dll.insertTail(node3);
        assertEquals(3, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node3, dll.getTail());

        // Delete at tail
        dll.deleteTail();
        assertEquals(2, dll.getSize());
        assertEquals(node2, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Delete at head
        dll.deleteHead();
        assertEquals(1, dll.getSize());
        assertEquals(node1, dll.getHead());
        assertEquals(node1, dll.getTail());

        // Delete at position
        dll.delete(node1);
        assertEquals(0, dll.getSize());
        assertNull(dll.getHead());
        assertNull(dll.getTail());
    }

    /** Testing CSLL **/

    @Test
    public void testCSLLEmptyConstructor() {
        CSLL list = new CSLL();
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testCSLLSingleNodeConstructor() {
        SNode node = new SNode(42);
        CSLL list = new CSLL(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
    }

    @Test
    public void testCSLLInsertHead() {
        CSLL list = new CSLL();
        SNode node = new SNode(42);
        list.insertHead(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        SNode node2 = new SNode(13);
        list.insertHead(node2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node, list.getTail());
    }

    @Test
    public void testCSLLInsertTail() {
        CSLL list = new CSLL();
        SNode node = new SNode(42);
        list.insertTail(node);
        assertFalse(list.isEmpty());
        assertEquals(1, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        SNode node2 = new SNode(13);
        list.insertTail(node2);
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node, list.getHead());
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testCSLLInsertAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insert(node1, 0);
        list.insert(node2, 1);
        list.insert(node3, 1);
        assertFalse(list.isEmpty());
        assertEquals(3, list.getSize());
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getHead().next);
        assertEquals(node2, list.getTail());
    }

    @Test
    public void testCSLLSortedInsert() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        SNode node4 = new SNode(99);
        list.sortedInsert(node1);
        list.sortedInsert(node2);
        list.sortedInsert(node3);
        list.sortedInsert(node4);
        assertFalse(list.isEmpty());
        assertEquals(4, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getHead().next);
        assertEquals(node1, list.getHead().next.next);
        assertEquals(node4, list.getTail());
    }

    @Test
    public void testCSLLRemoveHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.removeHead();
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node2, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(node3, removedNode);
    }

    @Test
    public void testCSLLRemoveTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.removeTail();
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(node1, removedNode);
    }

    @Test
    public void testCSLLRemoveAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode removedNode = list.remove(new SNode(13)); // pass the node to be removed
        assertFalse(list.isEmpty());
        assertEquals(2, list.getSize());
        assertEquals(node3, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(node2, removedNode);
    }


    @Test
    public void testCSLLGetNodeAtPosition() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        SNode nodeAtPos1 = list.getNode(1);
        assertEquals(node2, nodeAtPos1);
        SNode nodeAtPos2 = list.getNode(2);
        assertEquals(node1, nodeAtPos2);
    }

    @Test
    public void testCSLLClearList() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    @Test
    public void testCSLLContains() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(42);
        SNode node2 = new SNode(13);
        SNode node3 = new SNode(7);
        list.insertHead(node1);
        list.insertHead(node2);
        assertFalse(list.contains(node3));
        list.insertHead(node3);
        assertTrue(list.contains(node3));
    }

    /** Testing CDLL Class**/

    @Test
    public void testInsertHead() {
        CDLL list = new CDLL();
        DNode node = new DNode(1);
        list.insertHead(node);
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testCDLLInsertTail() {
        CDLL list = new CDLL();
        DNode node = new DNode(1);
        list.insertTail(node);
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        assertEquals(1, list.getSize());
    }

    @Test
    public void testCDLLInsert() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        list.insert(node2, 1);
        assertEquals(node1, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(2, list.getSize());
    }

    @Test
    public void testIsSorted() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.insert(node3, 2);
        assertTrue(list.isSorted());
        list.insertHead(node3);
        assertFalse(list.isSorted());
    }

    @Test
    public void testSearch() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.insert(node3, 2);
        assertEquals(node2, list.search(node2));
        assertNull(list.search(new DNode(4)));
    }

    @Test
    public void testDeleteHead() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.deleteHead();
        assertEquals(node2, list.getHead());
        assertEquals(node2, list.getTail());
        assertEquals(1, list.getSize());
        list.deleteHead();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testDeleteTail() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.deleteTail();
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail());
        assertEquals(1, list.getSize());
        list.deleteTail();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }

    @Test
    public void testInsertAtIndex() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        DNode node4 = new DNode(4);
        list.insert(node1, 0);
        list.insert(node3, 1);
        list.insert(node4, 2);
        list.insert(node2, 1);
        assertEquals(node1, list.getHead());
        assertEquals(node4, list.getTail());
        assertEquals(4, list.getSize());
    }

    @Test
    public void testDelete() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.insert(node3, 2);
        assertTrue(list.delete(node2));
        assertEquals(node1, list.getHead());
        assertEquals(node3, list.getTail());
        assertEquals(2, list.getSize());
        assertFalse(list.delete(new DNode(4)));
    }

    @Test
    public void testToString() {
        CDLL list = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        list.insertHead(node1);
        list.insert(node2, 1);
        list.insert(node3, 2);
        assertEquals("[1, 2, 3]", list.toString());
        list.deleteHead();
        assertEquals("[2, 3]", list.toString());
    }

    @Test
    public void testConstructorWithHead() {
        DNode node = new DNode(1);
        CDLL list = new CDLL(node);
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        assertEquals(1, list.getSize());
        assertNull(list.getHead().prev);
        assertNull(list.getTail().next);
    }

    /** Testing StackLL **/

    private AVL avl;

    @Test
    public void testStackLLPush() {
        StackLL stack = new StackLL();
        SNode node = new SNode(1);
        stack.push(node);
        assertEquals(node, stack.peek());
    }

    @Test
    public void testStackLLPop() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        SNode popped = stack.pop();
        assertEquals(node2, popped);
        assertEquals(node1, stack.peek());
    }

    @Test
    public void testStackLLPeek() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        assertEquals(node2, stack.peek());
        stack.pop();
        assertEquals(node1, stack.peek());
    }

    @Test
    public void testStackLLIsEmpty() {
        StackLL stack = new StackLL();
        assertTrue(stack.isEmpty());
        SNode node = new SNode(1);
        stack.push(node);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testStackLLClear() {
        StackLL stack = new StackLL();
        SNode node = new SNode(1);
        stack.push(node);
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackLLInsert() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.insert(node2, 1);
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.pop());
    }

    @Test
    public void testStackLLInsertTail() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.insertTail(node2);
        assertEquals(node2, stack.pop());
        assertEquals(node1, stack.pop());
    }

    @Test
    public void testStackLLDeleteHead() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        stack.deleteHead();
        assertEquals(node1, stack.pop());
    }

    @Test
    public void testStackLLDeleteTail() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        stack.deleteTail();
        assertEquals(node2, stack.pop());
    }

    @Test
    public void testStackLLDelete() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        stack.delete(node1);
        assertEquals(node2, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackLLConstructor() {
        SNode node = new SNode(1);
        StackLL stack = new StackLL(node);
        assertEquals(node, stack.peek());
    }

    @Test
    public void testStackLLDisplay() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        stack.push(node1);
        stack.push(node2);
        stack.display();
        String expectedOutput = "2 1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testStackLLIsSorted() {
        StackLL stack = new StackLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        stack.push(node1);
        stack.push(node3);
        stack.push(node2);
        assertTrue(stack.isSorted());
        stack.pop();
        stack.push(new SNode(4));
        assertFalse(stack.isSorted());
    }

    /** Testing QueueLL **/

    @Test
    public void testQueueLLEnqueue() {
        QueueLL queue = new QueueLL();
        SNode node = new SNode(1);
        queue.enqueue(node);
        assertEquals(node, queue.peek());
    }

    @Test
    public void testQueueLLDequeue() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        queue.enqueue(node1);
        queue.enqueue(node2);
        queue.enqueue(node3);
        assertEquals(node1, queue.dequeue());
        assertEquals(node2, queue.dequeue());
        assertEquals(node3, queue.dequeue());
    }

    @Test
    public void testQueueLLPeek() {
        QueueLL queue = new QueueLL();
        SNode node = new SNode(1);
        queue.enqueue(node);
        assertEquals(node, queue.peek());
    }

    @Test
    public void testQueueLLIsEmpty() {
        QueueLL queue = new QueueLL();
        assertTrue(queue.isEmpty());
        SNode node = new SNode(1);
        queue.enqueue(node);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testQueueLLClear() {
        QueueLL queue = new QueueLL();
        SNode node = new SNode(1);
        queue.enqueue(node);
        assertFalse(queue.isEmpty());
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueLLInsertTail() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        queue.insertTail(node1);
        assertEquals(node1, queue.peek());
        queue.insertTail(node2);
        assertEquals(node1, queue.peek());
        queue.insertTail(node3);
        assertEquals(node1, queue.peek());
        assertEquals(3, queue.getSize());
    }

    @Test
    public void testQueueLLInsert() {
        QueueLL queue = new QueueLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        queue.insert(node1, 0);
        assertEquals(node1, queue.peek());
        queue.insert(node3, 1);
        assertEquals(node1, queue.peek());
        queue.insert(node2, 1);
        assertEquals(node1, queue.peek());
        assertEquals(3, queue.getSize());
    }

    @Test
    void testQueueLLConstructor() {
        SNode head = new SNode(1);
        QueueLL queue = new QueueLL(head);

        assertEquals(head, queue.getHead());
    }

    @Test
    void testQueueLLDisplay() {
        SNode head = new SNode(1);
        SNode second = new SNode(2);
        SNode third = new SNode(3);
        head.setNext(second);
        second.setNext(third);

        QueueLL queue = new QueueLL(head);
        queue.display(); // expects "1 -> 2 -> 3 -> null"
    }

    @Test
    void testQueueLLIsSorted() {
        SNode head = new SNode(1);
        SNode second = new SNode(2);
        SNode third = new SNode(3);
        head.setNext(second);
        second.setNext(third);

        QueueLL queue = new QueueLL(head);
        assertTrue(queue.isSorted());

        SNode invalidHead = new SNode(3);
        SNode invalidSecond = new SNode(1);
        SNode invalidThird = new SNode(2);
        invalidHead.setNext(invalidSecond);
        invalidSecond.setNext(invalidThird);

        QueueLL invalidQueue = new QueueLL(invalidHead);
        assertFalse(invalidQueue.isSorted());
    }

    /** Testing AVL **/
    @Test
    public void testAVLConstructorWithNode() {
        // Create a binary tree
        TNode node1 = new TNode();
        TNode node2 = new TNode();
        TNode node3 = new TNode();
        TNode node4 = new TNode();
        TNode node5 = new TNode();
        node1.setLeft(node2);
        node2.setLeft(node3);
        node2.setRight(node4);
        node1.setRight(node5);

        // Create a new AVL tree from the binary tree
        AVL avl = new AVL(node1);

        // Check that the AVL tree is balanced and has the correct structure
        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(4, avl.getRoot().getRight().getData());
        assertEquals(3, avl.getRoot().getLeft().getRight().getData());
        assertEquals(5, avl.getRoot().getRight().getRight().getData());
    }


    public void setUp() {
        avl = new AVL();
    }

    @Test
    public void testEmptyAVL() {
        assertNull(avl.getRoot());
    }

    @Test
    public void testAVLInsert() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);
        avl.insert(6);
        avl.insert(5);
        avl.insert(7);
        assertEquals(4, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(1, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(3, avl.getRoot().getLeft().getRight().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
        assertEquals(5, avl.getRoot().getRight().getLeft().getData());
        assertEquals(7, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testAVLDelete() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);
        avl.insert(6);
        avl.insert(5);
        avl.insert(7);
        avl.delete(1);
        avl.delete(7);
        avl.delete(2);
        assertEquals(4, avl.getRoot().getData());
        assertEquals(3, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
        assertEquals(5, avl.getRoot().getRight().getLeft().getData());
        assertNull(avl.getRoot().getLeft().getLeft());
        assertNull(avl.getRoot().getRight().getRight());
        assertNull(avl.search(1));
        assertNull(avl.search(7));
        assertNull(avl.search(2));
    }

    @Test
    public void testAVLSearch() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);
        avl.insert(6);
        avl.insert(5);
        avl.insert(7);
        TNode node = avl.search(6);
        assertEquals(6, node.getData());
        assertEquals(5, node.getLeft().getData());
        assertEquals(7, node.getRight().getData());
        assertNull(avl.search(8));
    }

    @Test
    public void testPrintInOrder() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);
        avl.insert(6);
        avl.insert(5);
        avl.insert(7);
        avl.printInOrder(); // 1 2 3 4 5 6 7
    }

    @Test
    public void testPrintBF() {
        avl.insert(4);
        avl.insert(2);
        avl.insert(3);
        avl.insert(1);
        avl.insert(6);
        avl.insert(5);
        avl.insert(7);
        avl.printBF(); // 4 2 6 1 3 5 7
    }

    @Test
    public void testAVLInsertCase1() {
        avl.insert(5);
        avl.insert(10);
        avl.insert(15);
        avl.insert(20);
        avl.insert(25);
        avl.insert(30);
        assertEquals(15, avl.getRoot().getData());
        assertEquals(5, avl.getRoot().getLeft().getData());
        assertEquals(10, avl.getRoot().getLeft().getRight().getData());
        assertEquals(20, avl.getRoot().getRight().getData());
        assertEquals(25, avl.getRoot().getRight().getRight().getData());
        assertEquals(30, avl.getRoot().getRight().getRight().getRight().getData());
    }

    @Test
    public void testAVLInsertCase2() {
        avl.insert(30);
        avl.insert(25);
        avl.insert(20);
        avl.insert(15);
        avl.insert(10);
        avl.insert(5);
        assertEquals(15, avl.getRoot().getData());
        assertEquals(5, avl.getRoot().getLeft().getData());
        assertEquals(10, avl.getRoot().getLeft().getRight().getData());
        assertEquals(20, avl.getRoot().getRight().getData());
        assertEquals(25, avl.getRoot().getRight().getLeft().getData());
        assertEquals(30, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testAVLInsertCase3() {
        avl.insert(30);
        avl.insert(25);
        avl.insert(35);
        avl.insert(20);
        avl.insert(27);
        avl.insert(40);
        assertEquals(30, avl.getRoot().getData());
        assertEquals(25, avl.getRoot().getLeft().getData());
        assertEquals(20, avl.getRoot().getLeft().getLeft().getData());
        assertEquals(27, avl.getRoot().getLeft().getRight().getData());
        assertEquals(35, avl.getRoot().getRight().getData());
        assertEquals(40, avl.getRoot().getRight().getRight().getData());
    }

    @Test
    public void testAVLInsertCase4() {
        avl.insert(5);
        avl.insert(10);
        avl.insert(8);
        avl.insert(15);
        avl.insert(12);
        avl.insert(20);
        assertEquals(10, avl.getRoot().getData());
        assertEquals(5, avl.getRoot().getLeft().getData());
        assertEquals(8, avl.getRoot().getLeft().getRight().getData());
        assertEquals(15, avl.getRoot().getRight().getData());
        assertEquals(12, avl.getRoot().getRight().getLeft().getData());
        assertEquals(20, avl.getRoot().getRight().getRight().getData());
    }




}
