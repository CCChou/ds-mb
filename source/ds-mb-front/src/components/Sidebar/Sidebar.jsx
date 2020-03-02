import React from 'react';
import { Link } from 'react-router-dom';

class Sidebar extends React.Component {
  render() {
    return (
      <div className="col-2">
        <nav
          className="nav d-flex flex-column border-right bg-light"
          style={{ minHeight: 'calc(100vh - 56px)' }}
        >
          <ul className="list-group list-group-flush">
            <li className="list-group-item bg-light">
              <Link to="/article/list" className="text-dark">
                文章列表
              </Link>
            </li>
            <li className="list-group-item bg-light">
              <Link to="/article/list/mine" className="text-dark">
                我的文章
              </Link>
            </li>
          </ul>
        </nav>
      </div>
    );
  }
}

export default Sidebar;
