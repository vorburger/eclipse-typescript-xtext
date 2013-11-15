interface Person {
    name: string;
    birthYear: number
}

interface Employee extends Person {
    department: {
        name: string
        location: string
    }
}

interface Organization {
    name: string
    employees: Employee[]
}
