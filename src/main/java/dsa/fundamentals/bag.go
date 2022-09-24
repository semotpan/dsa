package main

import "fmt"

type Bag[C any] struct {
	elements []C
	iterator *BagIterator[C]
}

func NewStringBag() *Bag[string] {
	b := &Bag[string]{
		elements: make([]string, 0),
	}

	iterator := &BagIterator[string]{
		bag:   b,
		index: 0,
	}
	b.iterator = iterator
	return b
}

func (d *Bag[C]) Add(item C) {
	d.elements = append(d.elements, item)
}

func (d *Bag[C]) Size() int {
	return len(d.elements)
}

func (d *Bag[C]) IsEmpty() bool {
	return d.Size() == 0
}

func (d *Bag[C]) Iterator() *BagIterator[C] {
	return d.iterator
}

type BagIterator[C any] struct {
	index int
	bag   *Bag[C]
}

func (b *BagIterator[C]) HasNext() bool {
	return b.index < b.bag.Size()

}
func (b *BagIterator[C]) Next() C {
	if !b.HasNext() {
		panic("No elements")
	}
	el := b.bag.elements[b.index]
	b.index++
	return el
}

// ***************** Testing *****************
func main() {
	stringBag := NewStringBag()

	stringBag.Add("Item 1")
	stringBag.Add("Item 2")

	fmt.Println(stringBag.Size())

	iterator := stringBag.Iterator()

	for iterator.HasNext() {
		fmt.Println(iterator.Next())
	}
}
