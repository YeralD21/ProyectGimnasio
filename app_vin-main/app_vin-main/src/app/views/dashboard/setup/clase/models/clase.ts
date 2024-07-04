export interface Instructor {
    id: number;
    nombre: string;
    especialidad: string;
}

export interface Clase {
    id?: number;
    tipo: string;
    hora: string;
    costo: number;
    cuposDisponibles: number;
    instructor: Instructor;  // Asegúrate de que instructor es del tipo Instructor
}
