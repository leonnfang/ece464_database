import { render } from "react-dom";
import {
  BrowserRouter,
  Routes,
  Route,
  useNavigate
} from "react-router-dom";
import Overall from './Overall';
import Home from './Home';
import Details from './Details';
import axios from 'axios';
import React, { useState, Component } from 'react';
import './index.css';
const {  Layout, Menu, Input  } = require('antd');
const { Header, Content, Footer } = Layout;
const { Search } = Input;

function AppRouter(props) {
  const navigate = useNavigate();
  const [ name, setName ] = useState('');
  const onSearch = (value) => {
    setName(value);
    console.log("value: ", name);
    navigate('/overall');
  }
  return (
    <Layout>
      <Header style={{ position: 'fixed', zIndex: 1, width: '100%', textAlign:'center' }}>
        {/* <div className="logo">
          <img src="https://cdn.dribbble.com/users/295073/screenshots/14866706/media/88aa13fef16e9fe6f61a05ad0f2c28c6.jpg?compress=1&resize=400x300" alt="logo" />
        </div> */}
        <div className="logo">Ricepe Wizard</div>
        {/* <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['2']}>
          <Menu.Item key="1">nav 1</Menu.Item>
          <Menu.Item key="2">nav 2</Menu.Item>
          <Menu.Item key="3">nav 3</Menu.Item>
        </Menu> */}
        <Search placeholder="input recipe name" onSearch={onSearch} style={{ width: 200, float: 'right', padding: 15 }} />
      </Header>
      <Content className="site-layout" style={{ padding: '0 50px', marginTop: 64 }}>
        {/* <Breadcrumb style={{ margin: '16px 0' }}>
          <Breadcrumb.Item>Home</Breadcrumb.Item>
          <Breadcrumb.Item>List</Breadcrumb.Item>
          <Breadcrumb.Item>App</Breadcrumb.Item>
        </Breadcrumb> */}
        <div className="site-layout-background" style={{ padding: 24, minHeight: 380 }}>
          <Routes>
            <Route path="/" element={<Home />}>
            </Route>
            <Route path="/overall" element={<Overall name={name}/>}>
            </Route>
            <Route path="/details" element={<Details />}>
            </Route>
          </Routes>
        </div>
      </Content>
      <Footer style={{ textAlign: 'center' }}>Jinhan & Leon ©2021 Databases</Footer>
    </Layout>  
  );
  
}
export default AppRouter;