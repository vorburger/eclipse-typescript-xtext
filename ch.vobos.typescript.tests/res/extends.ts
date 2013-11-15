interface Person {
    name: string;
    birthYear: number
}

interface Resource {
	load: number
}

interface Employee extends Person, Resource {
    name: string
}
