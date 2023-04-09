import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import { Container, Paper } from '@mui/material';

export default function Student() {
    const paperStyle = {padding: "50px 20px", width: 600, margin: "20px auto"}
    const [name, setName] = React.useState('')
    const [address, setAddress] = React.useState('')
    const [students, setStudents] = React.useState([])
    const handleClick = (e) => {
        e.preventDefault()
        const student = {name, address}
        fetch("http://localhost:8080/api/student", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(student)
        })
            .then(() => console.log("New student "))
    }

    React.useEffect(() => {
        fetch("http://localhost:8080/api/students")
            .then(res => res.json())
            .then(data => {
                setStudents(data) 
            }) 
    }, [students])
    return (
        <Container>
            <Box
            component="form"
            sx={{
                '& > :not(style)': { m: 1 },
            }}
            noValidate
            autoComplete="off"
            >
                <Paper elevation={3} style={paperStyle}>
                    <h1 style={{ color: "blue" }}><u>Add Student</u></h1>
                    <TextField 
                        id="standard-basic" 
                        label="Student Name" 
                        variant="outlined" 
                        fullWidth 
                        value={name} 
                        onChange={(e) => setName(e.target.value)}
                    />
                    <TextField 
                        id="standard-basic"     
                        label="Student Address" 
                        variant="outlined" 
                        fullWidth 
                        margin="normal"
                        value={address} 
                        onChange={(e) => setAddress(e.target.value)}
                    />
                    <Button 
                        variant="contained" 
                        color="secondary"
                        onClick={handleClick}
                    >
                        Submit
                    </Button>

                </Paper>
            </Box>
                <h2>Students</h2>
                <Paper elevation={3} style={paperStyle}>
                    {students.map(student => (
                        <Paper 
                            elevation={6} 
                            style={{margin: "10px", padding: "15px", textAlign: "left"}} 
                            key={student.id}
                        >
                            Id: {student.id},<br />
                            Name: {student.name},<br />
                            Address: {student.address}
                        </Paper>
                    ))}
                /</Paper>
        </Container>   
    );
}