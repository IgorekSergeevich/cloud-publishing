import React from "react";
import {UserList} from "./../views/users/user-list.jsx";
//import {getUserList, deleteUserById} from "../../api/user-api";
import {connect} from "react-redux";
import {saveSearchResultAction, deleteSearchItemAction} from "./../../actions/search-actions";
import {searchUserAction} from "../../actions/search-actions";
import users from "../../../test-data/users.json";


class UserListContainer extends React.Component {

    render() {
        return <UserList userList = {this.props.userList} deleteUser={(id) => this.deleteUser(id)}/>;
    }

    componentDidMount() {
        /*getUserList().then(this.props.saveUsersAction);*/
        this.props.searchUserAction();
        this.props.saveSearchResultAction(users);
    }

    deleteUser(id) {
        this.props.deleteSearchItemAction(id);
        //deleteUserById(id).then(this.props.deleteSearchItemAction);
    }

}

function mapStateToProps(state) {
    return {
        userList : state.search.searchList
    };
}

const mapDispatchToProps = {
    saveSearchResultAction,
    deleteSearchItemAction,
    searchUserAction
}

export default connect(mapStateToProps, mapDispatchToProps)(UserListContainer);
