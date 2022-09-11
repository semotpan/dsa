package main

import (
	"bytes"
	"fmt"
)

type LinkedList struct {
	first *node
	last  *node
	len   int
}

type node struct {
	next  *node
	prev  *node
	value interface{}
}

func newLinkedList() LinkedList {
	return LinkedList{
		len: 0,
	}
}

func (l *LinkedList) Add(value interface{}) {

	newNode := &node{
		prev:  nil,
		next:  nil,
		value: value,
	}

	last := l.last
	l.last = newNode

	if last == nil {
		l.first = newNode
		l.last = newNode
	} else {
		last.next = newNode
		newNode.prev = last
	}

	l.len++
}

func (l *LinkedList) Size() int {
	return l.len
}

func (l *LinkedList) RemoveByValue(value interface{}) bool {

	for it := l.first; it != nil; it = it.next {
		if it.value == value {
			unlink(l, it)
			return true
		}
	}

	return false
}

func (l *LinkedList) RemoveByIndex(index int) int {

	if index >= l.len {
		panic(fmt.Sprintf("Array Index Out Of Bounds Index: %v Size: %v", index, l.len))
	}

	var i = 0
	for it := l.first; it != nil; it = it.next {
		if i == index {
			unlink(l, it)
			return i
		}

		i++
	}

	return -1
}

func unlink(l *LinkedList, n *node) {

	if n == nil {
		return
	}
	l.len--

	if l.first == n {
		l.first = l.first.next
		l.first.prev = nil
		return
	}

	if l.last == n {
		l.last = l.last.prev
		l.last.next = nil
		return
	}

	n.prev.next = n.next
	n.next.prev = n.prev
}

func (l LinkedList) Print() string {
	var b bytes.Buffer
	b.WriteString("[")

	for f := l.first; f != nil; f = f.next {
		b.WriteString(fmt.Sprintf("%v", f.value))

		if f.next != nil {
			b.WriteString(", ")
		}
	}
	b.WriteString("]\n")

	return b.String()
}

// ***************** Testing *****************
func main() {

	list := newLinkedList()

	list.Add(10)
	list.Add(112)
	list.Add(20)
	list.Add(10)
	list.Add(100)
	list.Add(23)

	fmt.Print("List: ", list.Print())
	fmt.Println("Size: ", list.Size())

	list.RemoveByValue(100)

	fmt.Print("List: ", list.Print())
	fmt.Println("Size: ", list.Size())

	list.RemoveByIndex(1)

	fmt.Print("List: ", list.Print())
	fmt.Println("Size: ", list.Size())
}
