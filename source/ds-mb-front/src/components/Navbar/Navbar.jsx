import React from 'react';
import Dropdowns from '../Dropdowns';

class Navbar extends React.Component {
  render() {
    return (
      <div className="navbar navbar-dark bg-primary">
        <a className="navbar-brand" href="#">
          Navbar
        </a>
        <Dropdowns />
      </div>
    );
  }
}

export default Navbar;
