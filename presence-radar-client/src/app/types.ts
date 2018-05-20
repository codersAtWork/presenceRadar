export class Person {
    public id: number;
    public name: string;
    public tokens: Token[];
}

export class Token {
    public id: number;
    public name: string;
    public uid: string;
    public active: boolean;
    public foundAction: String;
    public lostAction: String;
}
  
export type Query = {
    allPersons: Person[];
    person: Person;
}