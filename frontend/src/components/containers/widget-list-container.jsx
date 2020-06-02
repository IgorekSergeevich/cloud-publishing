import { connect } from "react-redux";
import { WidgetList } from "../views/widgets/widget-list.jsx";
import React from "react";
import widgets from "../../../test-data/widget.json";
import {searchWidgetAction, saveSearchResultAction, deleteSearchItemAction} from "../../actions/search-actions";
//import {deleteWidgetById, getWidgetList} from "../../api/widget-api";

class WidgetListContainer extends React.Component {
    
    render() {
        return <WidgetList widgetList = {this.props.widgetList} deleteWidget={id => this.deleteWidget(id)}/>;
    }

    componentDidMount() {
        this.props.searchWidgetAction();
        this.props.saveSearchResultAction(widgets);
    }

    deleteWidget(id) {
        this.props.deleteSearchItemAction(id);
    }
}

const mapDispatchToProps = {
    searchWidgetAction,
    saveSearchResultAction,
    deleteSearchItemAction
}

function mapStateToProps(state) {
    return {
        widgetList : state.search.searchList
    };
}

export default connect(mapStateToProps, mapDispatchToProps)(WidgetListContainer);