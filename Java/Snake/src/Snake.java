import java.awt.event.*;
import java.awt.*;

public class Snake {
	
	private Node head = null;
	private Node tail = null;
	int size = 0;
	private Yard yard = null;
	private Node node = new Node(20, 25, Dir.L);
	
	public Snake(Yard yard) {
		head = node;
		tail = node;
		this.yard = yard;
		this.size = 1;
	}
	public void draw(Graphics g) {
		if(size <= 0)	return;
		
		for (Node node = head; node != null; node = node.next) {
			node.draw(g);
		}
//		head = node;
//		while(node.next != null) {
//			
//			node.draw(g);
//			node = node.next;
//		}
		move();
		
	}
	private void move() {
		addToHead();
		deleteFromTail();
		checkDead();
	}
	
	

	private void checkDead() {
		//出界死
		if(head.row < 0 || head.row > (Yard.COLS * Yard.BLOCK_SIZE) || head.col < 0 || head.col > (Yard.ROWS * Yard.BLOCK_SIZE) ) {
			yard.setFlag(false);
		}
		//触碰自己身体则死.
			for(Node node = head.next; node != null; node = node.next) {
				if(head.row == node.row && head.col == node.col) {
					yard.setFlag(false);
				}
			}
	}



	private class Node {
		Node prev = null;
		Node next = null;
		Dir dir = Dir.L;
		int weight = Yard.BLOCK_SIZE;
		int height = Yard.BLOCK_SIZE;
		int row, col;
		
		
		public Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			
		}
		void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(col * Yard.BLOCK_SIZE, row * Yard.BLOCK_SIZE, weight, height);
			g.setColor(c);
		}
		
	}
	
	public void addToHead() {
		Node newNode = null;
		switch(head.dir) {
		case U:
			newNode = new Node(head.row - 1, head.col, head.dir);
			break;
		case D:
			newNode = new Node(head.row + 1, head.col, head.dir);
			break;
		case L:
			newNode = new Node(head.row, head.col - 1, head.dir);
			break;
		case R:
			newNode = new Node(head.row, head.col + 1, head.dir);
			break;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		
	}
	
	private void deleteFromTail(){
		if(size == 0)	return;
		tail = tail.prev;
		tail.next = null;
	}

	private void addToTail() {

		Node newNode = null;
		switch(tail.dir) {
		case U:
			newNode = new Node(tail.row + 1, tail.col, tail.dir);
			break;
		case D:
			newNode = new Node(tail.row - 1, tail.col, tail.dir);
			break;
		case L:
			newNode = new Node(tail.row, tail.col + 1, tail.dir);
			break;
		case R:
			node = new Node(tail.row, tail.col - 1, tail.dir);
			break;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size ++;
	}
	
	public Rectangle getRect() {
		return new Rectangle(head.col * Yard.BLOCK_SIZE, head.row * Yard.BLOCK_SIZE, head.weight, head.height);
	}
	
	public boolean eat(Egg e) {
		if(this.getRect().intersects(e.getRect())) {
			e.reAppear();
			addToHead();
			return true;
		}	
		return false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_UP:
			if(head.dir != Dir.D)	
				head.dir = Dir.U;
			break;
		case KeyEvent.VK_DOWN:
			if(head.dir != Dir.U)	
				head.dir = Dir.D;
			break;
		case KeyEvent.VK_LEFT:
			if(head.dir != Dir.R)	
				head.dir = Dir.L;
			break;
		case KeyEvent.VK_RIGHT:
			if(head.dir != Dir.L)	
				head.dir = Dir.R;
			break;
		}
	}

}
