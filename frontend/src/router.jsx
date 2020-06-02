import React from "react";
import MainLayout from "./components/layouts/main/main-layout.jsx";
import { BrowserRouter, Route } from "react-router-dom";
import Home from "./components/views/home/home.jsx";
import SearchLayoutContainer from "./components/containers/search-layout-container.jsx";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import {PrivateRoute} from "./components/auth/private-router.jsx";
import {AuthProvider} from "./components/auth/auth-provider.jsx";
import {PrivatePage} from "./components/views/pages/private-page.jsx";
import {PublicPage} from "./components/views/pages/public-page.jsx";
import {LoginForm} from "./components/views/login/login-form.jsx";
import { Callback } from "./components/auth/callback-handler.jsx";

export default (
    <BrowserRouter>
        <Container>
            <Row>
                <MainLayout>
                    <AuthProvider>
                        <Route path="/" exact>{Home}</Route>
                        <Route path={["/users", "/widgets"]} component={SearchLayoutContainer} />
                        <PrivateRoute path="/private" component={PrivatePage}/>
                        <Route path="/login" component={LoginForm}/>
                        <Route path="/public" component={PublicPage}/>
                        <Route path="/callback" component={Callback}/>
                    </AuthProvider>
                </MainLayout>
            </Row>
        </Container>
    </BrowserRouter>
);
