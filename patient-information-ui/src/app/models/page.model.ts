export interface Page<T>{
    number: number;
    size: number;
    content: T[];
    numberOfElements: number;
    totalPages: number;
    totalElements: number;
}