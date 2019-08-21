//
int width;
int height;
int[][] food;
int score;
int foodIndex;
HashSet<Integer> set;
Deque<Integer> deque;

public _353_DesignSnakeGame(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.food = food;
    set = new HashSet<>();
    deque = new LinkedList<>();
    score = 0;
    foodIndex = 0;
    set.add(0); //start
    deque.offerLast(0); // start
}

public int move(String direction) {
    if (score == -1) {
        return -1;
    }
    
    int rowHead = deque.peekFirst() / width;
    int colHead = deque.peekFirst() % width;
    
    switch (direction) {
        case "U" : rowHead--;
            break;
        case "D" : rowHead++;
            break;
        case "L" : colHead--;
            break;
        default : colHead++;
    }
    
    int head = rowHead * width + colHead;
    set.remove(deque.peekLast());
    if (rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
        return score = -1;
    }
    
    set.add(head);
    deque.offerFirst(head);
    
    if (foodIndex < food.length && food[foodIndex][0] == rowHead && food[foodIndex][1] = colHead) {
        score++;
        foodIndex++;
        set.add(deque.peekLast());
        return score;
    }
    
    deque.pollLast();
    return score;
}
