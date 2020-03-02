import React from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import Navbar from '../Navbar';
import Sidebar from '../Sidebar';
import Content from '../Content';
import UserConfig from '../UserConfig';

class Main extends React.Component {
  render() {
    return (
      <Router>
        <div className="container-fluid p-0">
          <Navbar />
          <div className="row no-gutters">
            <Sidebar />
            <Switch>
              <Route path="/article/list">
                <Content />
              </Route>
              <Route path="/article/list/mine">
                <Content />
              </Route>
              <Route path="/user/config">
                <UserConfig />
              </Route>
            </Switch>
          </div>
        </div>
      </Router>
    );
  }
}

export default Main;
