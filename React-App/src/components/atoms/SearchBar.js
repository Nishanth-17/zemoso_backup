import React from 'react';
import '../../styles/components/searchBar.css';

const SearchBar =(props) => {
    return(
    <div className="form-group has-search">
        <span className="fa fa-search form-control-feedback"></span>
        <input type="text" className="form-control" size="40" value={props.value} onChange={props.changed} placeholder="Search by Movie Name..." /> 
    </div>
    );
}
export default SearchBar;