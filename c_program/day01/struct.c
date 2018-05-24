#include <stdio.h>
#include <string.h>
#include <stdlib.h>
struct Books
{
	char title[10];
	char author[10];
	char subject[100];
	int book_id;
};

int main(){
	struct Books book1;
	struct Books book2;
	strcpy(book1.title,"第一个");

	printf("book1.title :%s",book1.title);

	system("notepad");
}