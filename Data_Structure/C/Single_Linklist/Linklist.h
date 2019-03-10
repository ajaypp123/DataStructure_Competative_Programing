
struct Node{
    struct Node *next;
    int data;
};

struct Linklist{
    struct Node *head;
    struct Node *tail;
    int count;
};

// typedef
typedef struct Node N;
typedef struct Linklist List;

void initList(List* temp);
void addFrist(List *li, int data);
void addLast(List *li, int data);
void delFrist(List *li);
void delLast(List *li);
void Display(List *li);
