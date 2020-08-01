import React from "react";
import { Link } from "react-router-dom";
import { Navbar, Nav, Button } from "react-bootstrap";
import { keycloak } from "../auth/keycloak";

export const AppNavbar = () => (
    <Navbar bg="light">
        <Navbar.Collapse id="basic-navbar-nav">
            <Navbar.Brand href="#bar">Cloud-publishing</Navbar.Brand>
            <Nav className="mr-auto">
                <Nav.Link to="/employees" as={Link}>Employees</Nav.Link>
                <Nav.Link to="/articles" as={Link}>Articles</Nav.Link>
            </Nav>
            <Nav>
            <Button variant="outline-dark" onClick={() => keycloak.logout()}>
                    LogOut
            </Button>
            </Nav>
        </Navbar.Collapse>

    </Navbar>
);