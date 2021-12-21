import React, { useState, Component, useEffect } from 'react';
import axios from 'axios';
import { Routs, Route, useParams, useLocation } from "react-router-dom";
const {  Layout, Menu, Breadcrumb, Card, Table, Tag, Space, List, Typography } = require('antd');
const { Header, Content, Footer } = Layout;

function Details() {
  const location = useLocation();
  const { name } = location.state;
  const [ recipe, setRecipe ] = useState({});
  console.log("details name: ", name);
  const getRecipe = async function (name){
    try{
      const response = await axios.get(`http://localhost:8080/info/${name}`);
      const responseData = response.data;
      console.log("details of: ", responseData);
      return responseData[0];
    }catch(e) {
      console.error(e);
    }
  }
  const columns = [
    {
      title: 'Ingredient',
      dataIndex: 'name',
      key: 'name'
    },
    {
      title: 'Qty',
      dataIndex: 'qty',
      key: 'qty',
    },
    {
      title: 'Unit',
      dataIndex: 'unit',
      key: 'unit',
    },
  ];
  useEffect(async ()=>{
    const recipe = await getRecipe(name);
    setRecipe(recipe);
  },[name]);

  return (
    <div className="site-layout-background" style={{ padding: 24, minHeight: 380 }}>
      <Card
        title={recipe.name}
        style={{ width: '100%', Height: '100%', margin: 10 }}
        bordered={false}
      >
        <div style={{textAlign:'center'}}>
          <img src={recipe.img_url} alt={recipe.name} style={{width: '50%', height:'auto'}}/>
        </div>
        <div>
          <h3>Ingredients</h3>
          <Table columns={columns} dataSource={recipe.ingredients} />
        </div>
        <div>
          <List
            header={<div>Steps</div>}
            // footer={<div>Footer</div>}
            bordered={false}
            dataSource={recipe.description}
            renderItem={(item,ind) => (
              <List.Item key={ind}>
                <Typography.Text mark>[{ind+1}]</Typography.Text> {item}
              </List.Item>
            )}
          />
        </div>
      </Card>
    </div>
  );
  
}

export default Details;
