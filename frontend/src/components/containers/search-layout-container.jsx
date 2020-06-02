import SearchLayout from "../layouts/search/search-layout.jsx";
import {connect} from "react-redux";

const mapStateToProps = state => ({
    searchType : state.searchState.searchType,
    searchAmount : state.search.searchList.length
});

export default connect(mapStateToProps)(SearchLayout);