import React from 'react';
import { Link } from 'react-router-dom';

class Dropdowns extends React.Component {
  render() {
    return (
      <div className="dropdown">
        <a
          className="btn btn-primary dropdown-toggle"
          href="#"
          role="button"
          id="dropdownMenuLink"
          data-toggle="dropdown"
          aria-haspopup="true"
          aria-expanded="false"
        >
          Setting
        </a>
        <div className="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
          <Link to="/user/config" className="dropdown-item">
            使用者設定
          </Link>
          <a className="dropdown-item" href="#">
            使用者管理
          </a>
          <a className="dropdown-item" href="#">
            文章管理
          </a>
        </div>
      </div>
    );
  }
}

export default Dropdowns;
