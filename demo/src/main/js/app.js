'use strict';

const React = require ('react');
const ReactDOM = require ('react-dom');
const client = require ('./client');

class App extends React.Component {
    constructor(props) {
        super (props);
        this.state = {eployees : []};
    }

    componentDidMount () {
        client ({method: 'GET', path: '/api/employees'}).done(response => {
            this.setState({employees: response.entity._embedded.employees});
        });
    }

    render () {
        return (
            <EmployeeList employees={this.state.employees}/>
        )
    }
}

class EmployeeList extends React.Component {
    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee._link.self.href} employee={employee}/>
        );
        return (
            <table>
                <tbody>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Description</th>
                    </tr>
                    {employees}
                </tbody>
            </table>
        )
    }
}

class Employee extends React.Component {
    render (){
        return (
            <tr>
                <td>{this.props.employee.firstname}</td>
                <td>{this.props.employee.lastname}</td>
                <td>{this.props.employee.decription}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)