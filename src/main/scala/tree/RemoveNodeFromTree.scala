package tree

object RemoveNodeFromTree {
  def remove(target:Node, parent:Node):Unit={
    //TODO
  }
  def process_childs_of_deleted_node(left:Node,right:Node):Node={
    if(left==null){
      if(right==null){
        return null
      }else{
        return right
      }
    }else if(right==null){
      return left
    }else{
      if(left.right==null){
        left.right=right
        return left
      }else {
        var parent = left
        while (parent.right.right != null) {
          parent = parent.right
        }
        //now parent.right is the right most node
        val new_root=parent.right
        parent.right=new_root.left
        new_root.left=left
        new_root.right=right

        return new_root
      }
    }
  }
}
