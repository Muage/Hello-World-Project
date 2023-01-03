import React from "react";

const students = [
    {
        id: 1,
        name: "One"
    },
    {
        id: 2,
        name: "Two"
    },
    {
        id: 3,
        name: "Three"
    },
    {
        id: 4,
        name: "Four"
    },
];

function AttendanceBook(props) {
    return (
        <ul>
            {/*
            {students.map((student) => {
                // return <li key={student.id}>{student.name}</li>;
                // return <li key={`student-id-${student.id}`}>{student.name}</li>; 
            */}

            {students.map((student, index) => {
                return <li key={index}>{student.name}</li>;
            })}
        </ul>
    );
}

export default AttendanceBook;